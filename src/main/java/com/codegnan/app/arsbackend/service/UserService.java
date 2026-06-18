package com.codegnan.app.arsbackend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.codegnan.app.arsbackend.dao.UserDao;
import com.codegnan.app.arsbackend.entity.User;

@Component
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public boolean signUp(User user) {

		User existingUser = userDao.findByEmail(user.getEmail());

		System.out.println("Email Received: " + user.getEmail());
		System.out.println("Existing User: " + existingUser);

		if (existingUser != null) {
			return false;
		}
		String encryptedPassword =
				passwordEncoder.encode(user.getPassword());

		user.setPassword(encryptedPassword);
		User savedUser = userDao.save(user);

		return savedUser != null;
	}
	@Transactional
	public boolean signIn(String email,
			String password) {

		User user =
				userDao.findByEmail(email);

		if (user == null) {
			return false;
		}

		return passwordEncoder.matches(
				password,
				user.getPassword()
				);
	}
	private BCryptPasswordEncoder passwordEncoder =
			new BCryptPasswordEncoder();

}