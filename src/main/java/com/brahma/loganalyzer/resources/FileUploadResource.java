package com.brahma.loganalyzer.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.DirectoryStream;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import io.dropwizard.views.View;

import com.codahale.metrics.annotation.Timed;
import com.sun.jersey.multipart.FormDataParam;
import com.brahma.loganalyzer.core.LogFile;
import com.brahma.loganalyzer.views.LogAnalysisSummaryView;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

@Path("/loganalyzer/upload")
public class FileUploadResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadResource.class);
	private final AtomicLong counter;
	
	public FileUploadResource(AtomicLong counter) {
		this.counter = counter;
	}

	@POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_HTML)
    public View uploadFileHandler(@FormDataParam("file") final InputStream inputStream, @FormDataParam("file-name") final String fileName) throws IOException {
        String uploadedFile = UUID.randomUUID().toString();
        java.nio.file.Path outputPath = FileSystems.getDefault().getPath("./tmp/.", fileName + uploadedFile);
        Files.copy(inputStream, outputPath);
        LOGGER.debug("File uploaded as " + fileName + uploadedFile);
        LogFile logFile = new LogFile(outputPath, fileName, counter.incrementAndGet());
        return new LogAnalysisSummaryView(logFile);
    }
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public long uploadFileHandler(String logName, String logFileContent) throws IOException {
		long logFileID = counter.incrementAndGet();
        LogFile logFile = new LogFile(logFileContent, logFileContent, logFileID);
        return logFileID;
    }	
}
