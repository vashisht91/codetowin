package com.piy.servicejaxb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class RestService {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Bean getDataXml() {
		Bean bean = new Bean();
		bean.setSummary("Application XML Todo Summary");
		bean.setDescription("Application XML Todo Description");
        return bean;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Bean getDataJson() {
		Bean bean = new Bean();
		bean.setSummary("Application XML Todo Summary");
		bean.setDescription("Application XML Todo Description");
        return bean;
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Bean getDataText() {
		Bean bean = new Bean();
		bean.setSummary("Application XML Todo Summary");
		bean.setDescription("Application XML Todo Description");
        return bean;
	}
}
