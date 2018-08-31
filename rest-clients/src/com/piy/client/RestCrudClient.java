package com.piy.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.ws.WebServiceClient;
import com.piy.crud.Element;

import org.glassfish.jersey.client.ClientConfig;

public class RestCrudClient {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		WebTarget target = client.target(getBaseURI());
		Element element = new Element("3","example");
		
		Response response = target.path("rest").path("elements").path(element.getId()).request(MediaType.APPLICATION_XML)
				.put(Entity.entity(element, MediaType.APPLICATION_XML), Response.class);
		
		System.out.println(response.getStatus());
		
		System.out.println(target.path("rest").path("elements").request().accept(MediaType.TEXT_XML).get(String.class));
		
	    System.out.println(target.path("rest").path("elements").request().accept(MediaType.APPLICATION_JSON).get(String.class));

	      // Get XML for application
	      System.out.println(target.path("rest").path("elements").request().accept(MediaType.APPLICATION_XML).get(String.class));

	      //Get Todo with id 1
	      Response checkDelete = target.path("rest").path("elements/1").request().accept(MediaType.APPLICATION_XML).get();

	      //Delete Todo with id 1
	      target.path("rest").path("elements/1").request().delete();

	      //Get get all Todos id 1 should be deleted
	      System.out.println(target.path("rest").path("elements").request().accept(MediaType.APPLICATION_XML).get(String.class));
	      
	      Form form = new Form();
	      form.param("id", "4");
	      form.param("summary","Demonstration of the client lib for forms");
	      response = target.path("rest").path("elements").request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);
	      System.out.println("Form response " + response.getStatus());
	      
	      System.out.println(target.path("rest").path("elements").request().accept(MediaType.APPLICATION_XML).get(String.class));


	}
	
	public static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/rest-api-crud").build();
	}

}
