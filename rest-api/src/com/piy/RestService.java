package com.piy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class RestService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmp() {
		return "Hello";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String getEmpHTML() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
		        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getEmpXML() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}
	
}
