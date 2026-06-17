package com.codegnan.app.arsbackend.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.codegnan.app.arsbackend.resource.UserResourceImpl;

@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(UserResourceImpl.class);
		register(CorsFilter.class);
	}
}