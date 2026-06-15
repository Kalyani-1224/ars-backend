package com.codegnan.app.arsbackend.resource;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(UserResourceImpl.class);
	}
}