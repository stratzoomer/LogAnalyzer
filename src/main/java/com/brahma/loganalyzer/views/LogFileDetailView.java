package com.brahma.loganalyzer.views;

import io.dropwizard.views.View;

import com.brahma.loganalyzer.core.LogFile;
import com.brahma.loganalyzer.resources.LogAnalysisSummaryResource;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

public class LogFileDetailView extends View  {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAnalysisSummaryResource.class);	
	private final LogFile logFile;
	
	public LogFileDetailView(LogFile logFile) {
		super("file-detail.ftl");
		this.logFile = logFile;
		LOGGER.info("Set logFile in LogFileDetailView to logID: " + this.logFile.getLogID());
	}

	public LogFile getLogFile() {
		return logFile;
	}

}
