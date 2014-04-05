package com.brahma.loganalyzer.views;

import io.dropwizard.views.View;
import com.brahma.loganalyzer.core.LogFile;

public class FileUploadView extends View  {
	private final LogFile logFile;
	
	protected FileUploadView(LogFile logFile) {
		super("file-upload.ftl");
		this.logFile = logFile;
	}

	public LogFile getLogFile() {
		return logFile;
	}

}
