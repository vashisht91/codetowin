package com.piy.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.sun.research.ws.wadl.Response;

public class TestClient {

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		
		WebTarget webTarget = client.target(getBaseURI());
		
//		String response = webTarget.path("rest").path("test").request()
//				.accept(MediaType.TEXT_PLAIN).get(Response.class).toString();
		
		String plainAnswer = webTarget.path("rest").path("test").request()
				.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		String xmlAnswer = webTarget.path("rest").path("test").request()
				.accept(MediaType.TEXT_XML).get(String.class);

		String htmlAnswer = webTarget.path("rest").path("test").request()
				.accept(MediaType.TEXT_HTML).get(String.class);
		
//		System.out.println(response);
        System.out.println(plainAnswer);
        System.out.println(xmlAnswer);
        System.out.println(htmlAnswer);

	}
	
	public static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/rest-api").build();
	}

}
