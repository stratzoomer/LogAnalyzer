package com.brahma.loganalyzer.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.nio.file.FileSystems;
import java.util.concurrent.atomic.AtomicLong;

import io.dropwizard.views.View;

import com.codahale.metrics.annotation.Timed;
import com.brahma.loganalyzer.core.LogFile;
import com.brahma.loganalyzer.views.LogAnalysisSummaryView;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

@Path("/loganalyzer/load-default")
@Produces(MediaType.TEXT_HTML)
public class DefaultLogResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultLogResource.class);
	private final AtomicLong counter;
	
	public DefaultLogResource(AtomicLong counter) {
		this.counter = counter;
	}

	
	@GET
    @Timed
	public View getDefaultLogStatistics() {
		//LOGGER.info("Inside getDefaultLogStatistics()");
		java.nio.file.Path path = FileSystems.getDefault().getPath(".", "web_server_log_example_140_lines.txt");
		LogFile logFile = new LogFile(path, LogFile.defaultFileName, counter.incrementAndGet());
		return new LogAnalysisSummaryView(logFile);
	}

}
