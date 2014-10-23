package com.mac.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.mac.rest.dao.UserDao;
import com.mac.rest.exception.CustomNotFoundException;
import com.mac.rest.model.User;

@Path("/users")
public class UserResource {

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String welcomePage() {
		return "<h1>Welcome to Java REST Web Service.<h1>";
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		List<User> users=new ArrayList<>(UserDao.instance.getModel().values());
		return users;
	}
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("userId") String userId) throws CustomNotFoundException {
		User user=UserDao.instance.getModel().get(userId);
		if(user==null) {
			throw new CustomNotFoundException("GET : user "+userId+" not found.");
		}
		return Response.ok(user).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response addUser(@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("age") int age,
			@FormParam("employee") boolean employee,
			@FormParam("maritalStatus") String maritalStatus, @Context UriInfo uriInfo) {
		
		int i = UserDao.instance.getModel().size()+1;
		User user = new User(i, firstName, lastName, age, employee, maritalStatus, null, null, null);
		UserDao.instance.getModel().put(String.valueOf(i), user);
		
		UriBuilder uriBuilder=UriBuilder.fromUri(uriInfo.getAbsolutePath());
		uriBuilder.path("/{id}");
		
		return Response.created(uriBuilder.build(i)).entity(user).type(MediaType.APPLICATION_JSON).build();
	}
	
	
	@DELETE
	@Path("/{userId}")
	public void deleteUser(@PathParam("userId") String userId) {
		UserDao.instance.getModel().remove(userId);
	}
	
	
	@PUT
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateUser(@PathParam("userId") String userId) {
		
	}
	
	
}
