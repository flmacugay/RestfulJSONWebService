package com.mac.rest;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


import com.mac.rest.dao.UserDao;
import com.mac.rest.model.User;

@Path("/users")
public class UserResource {

	
	@Context
	UriInfo uriInfo;
	
	
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String welcomePage() {
		return "<h1>Welcome to Java REST Web Service.<h1>";
	}
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("userId") String userId) {
		User user=UserDao.instance.getModel().get(userId);
		if(user==null) {
			throw new WebApplicationException(404);
		}
		return Response.ok(user).build();
	}
	
	/*
	 *     int index = ws.getWidgets().indexOf(widget);
    UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri());
    uriBuilder.path("{index}");
    EntityTag etag = new EntityTag(Hex.encodeHexString(widget.toString().getBytes()));
    return Response.created(uriBuilder.build(index)).
            tag(etag).
            entity(widget).
            type(MediaType.APPLICATION_JSON).
            build();
	 * */
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		List<User> users=new ArrayList<>(UserDao.instance.getModel().values());
		return users;
	}

	
	@PUT
	@Path("/{userId}")
	public void updateUser(@PathParam("userId") String userId) {
		
	}
	
	
}
