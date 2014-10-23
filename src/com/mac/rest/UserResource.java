package com.mac.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONException;

@Path("/users")
public class UserResource {

	private UserStub user=new UserStub();
	
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
	public Response getUser(@PathParam("userId") String userId) throws JSONException {
		return Response.ok(user.getUser(userId).toString()).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() throws JSONException {
		return Response.ok(user.getAllUsers()).build();
	}
	
	@PUT
	@Path("/{userId}")
	public void updateUser(@PathParam("userId") String userId) {
		
	}
	
	
}
