package com.codegnan.app.arsbackend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codegnan.app.arsbackend.entity.User;
import com.codegnan.app.arsbackend.service.UserService;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Component 
@Path("/user") 
public class UserResourceImpl implements UserResource {

	private final UserService userService;

	@Autowired
	public UserResourceImpl(UserService userService) {
	    this.userService = userService;
	}

	@POST
	@Path("/register") 
	@Produces(MediaType.TEXT_PLAIN)
	@Override 
	public String signUp(
			@FormParam("fullName") String fullName, 
			@FormParam("email") String email,
			@FormParam("password") String password,
			@FormParam("role") String role) {
		
		String responseText = "failure";

		User user = new User();
		user.setFullName(fullName);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		
		boolean isSignUpSuccessful = userService.signUp(user);
		if (isSignUpSuccessful) {
			responseText = "success";
		}
		return responseText;
	}
}