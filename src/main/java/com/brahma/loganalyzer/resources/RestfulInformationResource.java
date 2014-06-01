package com.brahma.loganalyzer.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brahma.loganalyzer.views.RestfulInformationView;

@Path("/loganalyzer/restful-information")
@Produces(MediaType.TEXT_HTML)
public class RestfulInformationResource {

	public RestfulInformationResource() {
	}

	@GET
    public RestfulInformationView showResponse() {
        return new RestfulInformationView();
    }
}
