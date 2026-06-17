package com.codegnan.app.arsbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegnan.app.arsbackend.entity.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);

}