package com.brahma.loganalyzer.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brahma.loganalyzer.views.LogAnalyzerMainView;

@Path("/loganalyzer")
@Produces(MediaType.TEXT_HTML)
public class LogAnalyzerMainResource {
	
    public LogAnalyzerMainResource() {
	}

	@GET
    public LogAnalyzerMainView showResponse() {
        return new LogAnalyzerMainView();
    }

}
