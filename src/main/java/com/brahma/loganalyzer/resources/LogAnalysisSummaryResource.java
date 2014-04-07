package com.brahma.loganalyzer.resources;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.views.View;

import com.codahale.metrics.annotation.Timed;
import com.brahma.loganalyzer.core.LogFile;
import com.brahma.loganalyzer.views.LogAnalysisSummaryView;
import com.brahma.loganalyzer.LogAnalyzerApplication;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

@Path("/loganalyzer/{logID}/results-summary")
public class LogAnalysisSummaryResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAnalysisSummaryResource.class);
	
	public LogAnalysisSummaryResource() {
	}

	
	@GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
	public View getDefaultLogStatisticsView(@PathParam("logID") long logID) {
		LogFile logFile = LogAnalyzerApplication.logFileList.get(new Long(logID));
		LOGGER.info("Calling LogAnalysisSummaryView for log " + logFile.getLogID());
		return new LogAnalysisSummaryView(logFile);
	}
	
	@GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
	public LogFile getLogStatistics(@PathParam("logID") long logID) {
		LogFile logFile = LogAnalyzerApplication.logFileList.get(new Long(logID));
		LOGGER.info("Calling LogAnalysisSummaryView for log " + logFile.getLogID());
		return logFile;
	}
	
	@GET
    @Timed
    @Path("/unique-ip-count")
    @Produces(MediaType.APPLICATION_JSON)
	public int getUniqueIPAddressCount(@PathParam("logID") long logID) {
		LogFile logFile = LogAnalyzerApplication.logFileList.get(new Long(logID));
		LOGGER.info("Calling LogAnalysisSummaryView for log " + logFile.getLogID());
		return logFile.getUniqueIPAddressCount();
	}

	@GET
    @Timed
    @Path("/line-count")
    @Produces(MediaType.APPLICATION_JSON)
	public int getLineCount(@PathParam("logID") long logID) {
		LogFile logFile = LogAnalyzerApplication.logFileList.get(new Long(logID));
		LOGGER.info("Calling LogAnalysisSummaryView for log " + logFile.getLogID());
		return logFile.getLineCount();
	}
	
	@GET
    @Timed
    @Path("/count-by-ip")
    @Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Integer> getIpAddressCounts(@PathParam("logID") long logID) {
		LogFile logFile = LogAnalyzerApplication.logFileList.get(new Long(logID));
		LOGGER.info("Calling LogAnalysisSummaryView for log " + logFile.getLogID());
		return logFile.getIpAddressCounts();
	}	 

	@GET
    @Timed
    @Path("/count-by-status")
    @Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Integer> getStatusCodeCounts(@PathParam("logID") long logID) {
		LogFile logFile = LogAnalyzerApplication.logFileList.get(new Long(logID));
		LOGGER.info("Calling LogAnalysisSummaryView for log " + logFile.getLogID());
		return logFile.getStatusCodeCounts();
	}	 
}
