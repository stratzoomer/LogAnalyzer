package com.brahma.loganalyzer.core;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.HashMap;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

public final class LogParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogParser.class);
	
	public static String getIPAddress(String logLine) {
		List<String> logTokens = Splitter.on(" ")
				.trimResults()
				.splitToList(logLine);
		return (String)logTokens.get(0);
	}
	
	public static HashMap<LogEntry.LogEntryPart, String> getLogEntryParts(String logLine) {
		HashMap<LogEntry.LogEntryPart, String> logEntryParts = new HashMap<LogEntry.LogEntryPart, String>(12);
		/* Regex from IBM developerWorks article
		 * http://www.ibm.com/developerworks/web/library/wa-apachelogs/
		 */
		Pattern p = Pattern.compile("^((?:(?:\\d){1,3}+\\.){3}\\d+) (-|\\w*) (-|\\w*) \\[([^\\[\\]:]+):(\\d+:\\d+:\\d+) ([\\-\\+]?\\d\\d\\d\\d)\\] \"(\\w+) ([\\S]+) ([^\"]+)\" (\\d+) (-|\\d+)( (?:\"[^\"]*\")( (?:\"[^\"]*\")( (?:\"[^\"]*\"))?)?)?\\s*\\Z");
		Matcher m = p.matcher(logLine);
		LOGGER.debug("m.groupCount(): " + m.groupCount());
		while(m.find()) {
			logEntryParts.put(LogEntry.LogEntryPart.ORIGIN_IP_ADDRESS, m.group(1));
			logEntryParts.put(LogEntry.LogEntryPart.USER_IDENTIFIER, m.group(2));
			logEntryParts.put(LogEntry.LogEntryPart.AUTH_USER, m.group(3));
			logEntryParts.put(LogEntry.LogEntryPart.LOG_DATE, m.group(4));
			logEntryParts.put(LogEntry.LogEntryPart.LOG_TIME, m.group(5));
			logEntryParts.put(LogEntry.LogEntryPart.TIMEZONE, m.group(6));
			logEntryParts.put(LogEntry.LogEntryPart.METHOD, m.group(7));
			logEntryParts.put(LogEntry.LogEntryPart.RESOURCE, m.group(8));
			logEntryParts.put(LogEntry.LogEntryPart.PROTOCOL, m.group(9));
			logEntryParts.put(LogEntry.LogEntryPart.STATUS_CODE, m.group(10));
			logEntryParts.put(LogEntry.LogEntryPart.SIZE, m.group(11));
			logEntryParts.put(LogEntry.LogEntryPart.CLIENT_INFO, m.group(12));
		}
		return logEntryParts;
	}
}
