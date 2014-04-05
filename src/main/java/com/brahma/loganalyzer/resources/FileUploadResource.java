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

import io.dropwizard.views.View;

import com.codahale.metrics.annotation.Timed;
import com.sun.jersey.multipart.FormDataParam;
import com.brahma.loganalyzer.core.LogFile;
import com.brahma.loganalyzer.views.LogAnalysisSummaryView;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

@Path("/loganalyzer/file-upload")
@Produces(MediaType.TEXT_HTML)
public class FileUploadResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadResource.class);
	
	public FileUploadResource() {
	}

	@POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public View uploadFileHandler(@FormDataParam("file") final InputStream inputStream, @FormDataParam("file-name") final String fileName) throws IOException {
		/*java.nio.file.Path dir = FileSystems.getDefault().getPath(".", ".");
		try (DirectoryStream<java.nio.file.Path> stream = Files.newDirectoryStream(dir)) {
		    for (java.nio.file.Path file: stream) {
		        System.out.println(file.getFileName());
		    }
		} catch (Exception x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(x);
		}*/
        String uploadedFile = UUID.randomUUID().toString();
        LOGGER.info(uploadedFile);
        java.nio.file.Path outputPath = FileSystems.getDefault().getPath("./tmp/.", uploadedFile);
        Files.copy(inputStream, outputPath);
        LogFile logFile = new LogFile(outputPath, fileName);
        return new LogAnalysisSummaryView(logFile);
    }
}
