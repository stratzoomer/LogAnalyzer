package com.brahma.loganalyzer.core;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

public class LogEntry {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogEntry.class);
	private final String originIPAddress;
	private final String userIdentifier;
	private final String authUser;
	private final String logDate;
	private final String logTime;
	private final String timeZone;
	private final String method;
	private final String resource;
	private final String protocol;
	private final String statusCode;
	private final String responseSize;
	private final String clientInfo;
	
	public enum LogEntryPart {
		ORIGIN_IP_ADDRESS, USER_IDENTIFIER, AUTH_USER, LOG_DATE, LOG_TIME, TIMEZONE, 
		METHOD, RESOURCE, PROTOCOL, STATUS_CODE, SIZE, CLIENT_INFO;
	}


	public LogEntry(String originIPAddress, String userIdentifier,
			String authUser, String logDate, String logTime, String timeZone,
			String method, String resource, String protocol, String statusCode,
			String responseSize, String clientInfo) {
		this.originIPAddress = originIPAddress;
		this.userIdentifier = userIdentifier;
		this.authUser = authUser;
		this.logDate = logDate;
		this.logTime = logTime;
		this.timeZone = timeZone;
		this.method = method;
		this.resource = resource;
		this.protocol = protocol;
		this.statusCode = statusCode;
		this.responseSize = responseSize;
		this.clientInfo = clientInfo;
		LOGGER.debug("Added logEntry: " +  this.toString());
	}



	public String getOriginIPAddress() {
		return originIPAddress;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public String getAuthUser() {
		return authUser;
	}

	public String getLogDate() {
		return logDate;
	}

	public String getLogTime() {
		return logTime;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public String getMethod() {
		return method;
	}

	public String getResource() {
		return resource;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getResponseSize() {
		return responseSize;
	}

	public String getClientInfo() {
		return clientInfo;
	}

	public String toString() {
		return "originIPAddress=" +  originIPAddress +
				";  userIdentifier=" +  userIdentifier +
				";  authUser=" +  authUser +
				";  logDate=" +  logDate +
				";  logTime=" +  logTime +
				";  timeZone=" +  timeZone +
				";  method=" +  method +
				";  resource=" +  resource +
				";  protocol=" +  protocol +
				";  statusCode=" +  statusCode +
				";  responseSize=" +  responseSize +
				";  clientInfo=" + clientInfo;
	}
}
