package com.codegnan.app.arsbackend.resource;

import org.springframework.stereotype.Component;

import com.codegnan.app.arsbackend.entity.User;
import com.codegnan.app.arsbackend.service.UserService;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Component
@Path("/user")
public class UserResourceImpl implements UserResource {
	private UserService userService;

	public UserResourceImpl(UserService userService) {
	    this.userService = userService;
	}

	@POST
	public String signUp(@FormParam("fname") String fullName,@FormParam("email") String email,@FormParam("password") String password,@FormParam("role") String role) {
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
	@POST
	@Path("/signin")
	public String signIn(
	        @FormParam("email") String email,
	        @FormParam("password") String password) {

	    boolean isLoginSuccessful =
	            userService.signIn(email, password);

	    if (isLoginSuccessful) {
	        return "success";
	    }

	    return "failure";
	}

}