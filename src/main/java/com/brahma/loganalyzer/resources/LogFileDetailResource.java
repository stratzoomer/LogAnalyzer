package com.brahma.loganalyzer.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brahma.loganalyzer.LogAnalyzerApplication;
import com.brahma.loganalyzer.core.LogFile;
import com.brahma.loganalyzer.views.LogFileDetailView;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

@Path("/loganalyzer/{logID}/log-file-detail")
@Produces(MediaType.TEXT_HTML)
public class LogFileDetailResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAnalysisSummaryResource.class);
	
    public LogFileDetailResource() {
	}

	@GET
	public LogFileDetailView showResponse(@PathParam("logID") long logID) {
		LogFile logFile = LogAnalyzerApplication.logFileList.get(new Long(logID));
		LOGGER.info("Calling LogFileDetailView for log " + logFile.getLogID());
		return new LogFileDetailView(logFile);
    }

}
