package com.piy.crud;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class ElementResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	
	public ElementResource(UriInfo uriInfo, Request request, String id) {
		super();
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Element getElement() {
		Element element = ElementDao.getElement().get(id);
		if(element == null) {
			throw new RuntimeException("Get: Element with " + id +  " not found");
		}
        return element;
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Element getElementXml() {
		Element element = ElementDao.getElement().get(id);
		if(element == null) {
			throw new RuntimeException("Get: Element with " + id +  " not found");
		}
        return element;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML) 
	public Response putElement(JAXBElement<Element> el) {
		Element e = el.getValue();
		return putAndGetResponse(e);
	}
	
	@DELETE
	public void deleteElement() {
		Element element = ElementDao.getElement().get(id);
		if(element == null) {
			throw new RuntimeException("Delete: Element with " + id +  " not found");
		}
	}
	
	public Response putAndGetResponse(Element e) {
		Response res;
		if(ElementDao.getElement().containsKey(e.getId())) {
			res = Response.noContent().build();
		}
		else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		ElementDao.getElement().put(e.getId(), e);
		return res;
	}
	
}