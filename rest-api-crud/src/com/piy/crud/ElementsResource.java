package com.piy.crud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/elements")
public class ElementsResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
    @Produces(MediaType.TEXT_XML)
    public List<Element> getTodosBrowser() {
        List<Element> todos = new ArrayList<Element>();
        todos.addAll(ElementDao.getElement().values());
        return todos;	
    }
	
	@GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Element> getTodos() {
        List<Element> todos = new ArrayList<Element>();
        todos.addAll(ElementDao.getElement().values());
        return todos;
    }
	
	@GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = ElementDao.getElement().size();
        return String.valueOf(count);
    }
	
	@POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newTodo(@FormParam("id") String id,
            @FormParam("summary") String summary,
            @FormParam("description") String description,
            @Context HttpServletResponse servletResponse) throws IOException {
		Element todo = new Element(id, summary);
        if (description != null) {
            todo.setDescription(description);
        }
        ElementDao.getElement().put(id, todo);

        servletResponse.sendRedirect("../CreateElement.html");
    }
	
	@Path("{element}")
	public ElementResource getElement(@PathParam("element") String id) {
		return new ElementResource(uriInfo, request, id);
	}
}

