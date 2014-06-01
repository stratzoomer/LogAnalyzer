package com.brahma.loganalyzer.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.Charset;

import javax.ws.rs.WebApplicationException;

import com.google.common.base.Optional;
import com.google.common.base.Splitter;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

import com.brahma.loganalyzer.LogAnalyzerApplication;

public class LogFile {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogFile.class);
	private String content = new String("");
	private final String logFileName;
	private int lineCount;
	private final long logID;
	private int uniqueIPAddressCount;
	public static final String defaultFileName = new String("Default Log File");

	private ArrayList<LogEntry> logEntries = new ArrayList<LogEntry>();
	private HashMap<String, Integer> ipAddressCounts = new HashMap<String, Integer>();
	private HashMap<String, Integer> statusCodeCounts = new HashMap<String, Integer>();

	public LogFile(String content, String logFileName, long logID) {
		this.logFileName = logFileName;
		this.logID = logID;
		this.lineCount = 0;
		Optional<String> possible = Optional.fromNullable(content);
		if (possible.isPresent()) {
			this.content = content;
			Iterable<String> result = Splitter.on(Pattern.compile("\r?\n"))
					.omitEmptyStrings()
					.trimResults()
					.split(content);
			for(String s: result){
				//LOGGER.debug(s);
				addLogEntry(s);
				this.lineCount++;
				LOGGER.info("Log file line count " + getLineCount());
			}
		} else {
			//raise exception for no content
		}
		LogAnalyzerApplication.logFileList.put(new Long(logID), this);
		LOGGER.info("Added log file " + logID);
	}

	public LogFile(java.nio.file.Path path, String logFileName, long logID) {
		this.logFileName = logFileName;
		this.logID = logID;
		this.lineCount = 0;
		try {
			BufferedReader reader = 
		            Files.newBufferedReader(path, Charset.defaultCharset() );
			String line = null;
			while ( (line = reader.readLine()) != null ) { 
				LOGGER.debug(line);
				setContent(getContent() + System.getProperty("line.separator") + line);
				addLogEntry(line);
				this.lineCount++;
			}		
		} catch (IOException ioe) {
			LOGGER.error("Exception while loading default log file " + ioe.getMessage());
			//raise exception for no content
		}
		LogAnalyzerApplication.logFileList.put(new Long(logID), this);
		LOGGER.info("Added log file " + logID);
	}
	
	@JsonProperty
	public String getContent() {
		return content;
	}

	public String getLogFileName() {
		return logFileName;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getLineCount() {
		return lineCount;
	}

	public long getLogID() {
		return logID;
	}

	@JsonProperty
	public HashMap<String, Integer> getIpAddressCounts() {
		return ipAddressCounts;
	}

	@JsonProperty
	public HashMap<String, Integer> getStatusCodeCounts() {
		return statusCodeCounts;
	}

	public int getUniqueIPAddressCount() {
		return uniqueIPAddressCount;
	}

	public void setUniqueIPAddressCount(int uniqueIPAddressCount) {
		this.uniqueIPAddressCount = uniqueIPAddressCount;
	}

	private void addLogEntry(String logEntryString) {
		HashMap<LogEntry.LogEntryPart, String> logEntryParts = LogParser.getLogEntryParts(logEntryString);
		if (logEntryParts.size() != 12) {
			throw new WebApplicationException();
		}
		logEntries.add(new LogEntry(logEntryParts.get(LogEntry.LogEntryPart.ORIGIN_IP_ADDRESS),
				logEntryParts.get(LogEntry.LogEntryPart.USER_IDENTIFIER),
				logEntryParts.get(LogEntry.LogEntryPart.AUTH_USER),
				logEntryParts.get(LogEntry.LogEntryPart.LOG_DATE),
				logEntryParts.get(LogEntry.LogEntryPart.LOG_TIME),
				logEntryParts.get(LogEntry.LogEntryPart.TIMEZONE),
				logEntryParts.get(LogEntry.LogEntryPart.METHOD),
				logEntryParts.get(LogEntry.LogEntryPart.RESOURCE),
				logEntryParts.get(LogEntry.LogEntryPart.PROTOCOL),
				logEntryParts.get(LogEntry.LogEntryPart.STATUS_CODE),
				logEntryParts.get(LogEntry.LogEntryPart.SIZE),
				logEntryParts.get(LogEntry.LogEntryPart.CLIENT_INFO)));
		if (ipAddressCounts.containsKey(logEntryParts.get(LogEntry.LogEntryPart.ORIGIN_IP_ADDRESS))) {
			int currentCount = ipAddressCounts.get(logEntryParts.get(LogEntry.LogEntryPart.ORIGIN_IP_ADDRESS));
			ipAddressCounts.put(logEntryParts.get(LogEntry.LogEntryPart.ORIGIN_IP_ADDRESS), ++currentCount);
		} else {
			ipAddressCounts.put(logEntryParts.get(LogEntry.LogEntryPart.ORIGIN_IP_ADDRESS), new Integer(1));
		}
		setUniqueIPAddressCount(ipAddressCounts.size());
		if (statusCodeCounts.containsKey(logEntryParts.get(LogEntry.LogEntryPart.STATUS_CODE))) {
			int currentCount = statusCodeCounts.get(logEntryParts.get(LogEntry.LogEntryPart.STATUS_CODE));
			statusCodeCounts.put(logEntryParts.get(LogEntry.LogEntryPart.STATUS_CODE), ++currentCount);
		} else {
			statusCodeCounts.put(logEntryParts.get(LogEntry.LogEntryPart.STATUS_CODE), new Integer(1));
		}
	}
	
	public ArrayList<LogEntry> getLogEntries() {
		return this.logEntries;
	}

	/*@JsonProperty
	public String getDefaultLogStatistics(java.nio.file.Path path) {
		return getContent();
	}*/
	
}
