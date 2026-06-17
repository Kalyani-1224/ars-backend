package com.codegnan.app.arsbackend.resource;

public interface UserResource {
	public String signUp(String fullName,String email,String password,String role);
	
	public String signIn(String email, String password);


}