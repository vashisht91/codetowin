package com.piy.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class RestJaxbClient {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		WebTarget target = client.target(getBaseURI());
		String xmlResponse = target.path("rest").path("hello")
				.request().accept(MediaType.TEXT_XML).get(String.class);
		String xmlAppResponse = target.path("rest").path("hello")
				.request().accept(MediaType.APPLICATION_XML).get(String.class);		
		String jsonAppResponse = target.path("rest").path("hello")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println(xmlResponse);
        System.out.println(xmlAppResponse);
        System.out.println(jsonAppResponse);
	}
	
	public static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/rest-api-jaxb").build();
	}

}
