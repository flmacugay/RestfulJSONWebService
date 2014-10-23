package com.mac.rest.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.Responses;

public class CustomNotFoundException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomNotFoundException() {
		super(Response.status(Responses.NOT_FOUND).build());
	}

	public CustomNotFoundException(String message) {
		super(Response.status(Responses.NOT_FOUND).entity(message).type(MediaType.TEXT_HTML).build());
	}

}
