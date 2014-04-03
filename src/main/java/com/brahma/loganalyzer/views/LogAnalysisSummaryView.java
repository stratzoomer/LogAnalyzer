package com.brahma.loganalyzer.views;

import io.dropwizard.views.View;
import com.brahma.loganalyzer.core.LogFile;

public class LogAnalysisSummaryView extends View {
	private final LogFile logFile;
	
	public LogAnalysisSummaryView(LogFile logFile) {
		super("results-summary.ftl");
		this.logFile = logFile;
	}
	
	public LogFile getLogFile() {
		return logFile;
	}
}
