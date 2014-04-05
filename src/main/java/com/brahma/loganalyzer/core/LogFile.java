package com.brahma.loganalyzer.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.Charset;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

public class LogFile {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogFile.class);
	private String content = new String("");
	private final String logFileName;
	private int uniqueIPAddressCount;

	private ArrayList<LogEntry> logEntries = new ArrayList<LogEntry>();
	private HashMap<String, Integer> ipAddressCounts = new HashMap<String, Integer>();
	private HashMap<String, Integer> statusCodeCounts = new HashMap<String, Integer>();

	public LogFile(String content) {
		this.logFileName = "User Defined Log File";
		Optional<String> possible = Optional.fromNullable(content);
		if (possible.isPresent()) {
			this.content = content;
			Iterable<String> result = Splitter.on(Pattern.compile("\r?\n"))
					.omitEmptyStrings()
					.trimResults()
					.split(content);
			for(String s: result){
				LOGGER.debug(s);
			}
		} else {
			//raise exception for no content
		}
	}

	public LogFile(java.nio.file.Path path) {
		this.logFileName = "Default Log File";
		try {
			BufferedReader reader = 
		            Files.newBufferedReader(path, Charset.defaultCharset() );
			String line = null;
			while ( (line = reader.readLine()) != null ) { 
				LOGGER.debug(line);
				setContent(getContent() + System.getProperty("line.separator") + line);
				addLogEntry(line);
			}		
		} catch (IOException ioe) {
			LOGGER.error("Exception while loading default log file " + ioe.getMessage());
			//raise exception for no content
		}
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

	public void addLogEntry(String logEntryString) {
		HashMap<LogEntry.LogEntryPart, String> logEntryParts = LogParser.getLogEntryParts(logEntryString);
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
