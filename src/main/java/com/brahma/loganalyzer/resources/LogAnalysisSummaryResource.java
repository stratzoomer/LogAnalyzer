package com.brahma.loganalyzer.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.concurrent.atomic.AtomicLong;

import io.dropwizard.views.View;

import com.codahale.metrics.annotation.Timed;
import com.brahma.loganalyzer.core.LogFile;
import com.brahma.loganalyzer.views.LogAnalysisSummaryView;
import com.brahma.loganalyzer.LogAnalyzerApplication;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

@Path("/loganalyzer/{logID}/results-summary")
@Produces(MediaType.TEXT_HTML)
public class LogAnalysisSummaryResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAnalysisSummaryResource.class);
	private final AtomicLong counter;
	
	public LogAnalysisSummaryResource(AtomicLong counter) {
		this.counter = counter;
	}

	
	@GET
    @Timed
	public View getDefaultLogStatistics(@PathParam("logID") long logID) {
		//LOGGER.info("Inside getDefaultLogStatistics()");
		//java.nio.file.Path path = FileSystems.getDefault().getPath(".", "netflix_phone_screen_log.txt");
		//LogFile logFile = new LogFile(path, LogFile.defaultFileName, counter.incrementAndGet());
		LogFile logFile = LogAnalyzerApplication.logFileList.get(new Long(logID));
		LOGGER.info("Calling LogAnalysisSummaryView for log " + logFile.getLogID());
		return new LogAnalysisSummaryView(logFile);
	}
	
	@GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
	public LogFile getLogStatistics(@PathParam("logID") long logID) {
		//LOGGER.info("Inside getDefaultLogStatistics()");
		//java.nio.file.Path path = FileSystems.getDefault().getPath(".", "netflix_phone_screen_log.txt");
		//LogFile logFile = new LogFile(path, LogFile.defaultFileName, counter.incrementAndGet());
		LogFile logFile = LogAnalyzerApplication.logFileList.get(new Long(logID));
		LOGGER.info("Calling LogAnalysisSummaryView for log " + logFile.getLogID());
		return logFile;
	}
}
