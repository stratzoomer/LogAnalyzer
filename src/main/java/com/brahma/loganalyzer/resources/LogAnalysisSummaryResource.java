package com.brahma.loganalyzer.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.nio.file.FileSystems;
import io.dropwizard.views.View;
import com.codahale.metrics.annotation.Timed;
import com.brahma.loganalyzer.core.LogFile;
import com.brahma.loganalyzer.views.LogAnalysisSummaryView;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

@Path("/loganalyzer/results-summary")
@Produces(MediaType.TEXT_HTML)
public class LogAnalysisSummaryResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAnalysisSummaryResource.class);
	
	public LogAnalysisSummaryResource() {
		//LOGGER.info("Inside DefaultLogFileResource() contructor");
	}

	
	@GET
    @Timed
	public View getDefaultLogStatistics() {
		//LOGGER.info("Inside getDefaultLogStatistics()");
		java.nio.file.Path path = FileSystems.getDefault().getPath(".", "netflix_phone_screen_log.txt");
		LogFile logFile = new LogFile(path);
		return new LogAnalysisSummaryView(logFile);
	}

}
