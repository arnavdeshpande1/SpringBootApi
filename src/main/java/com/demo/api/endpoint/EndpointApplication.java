package com.demo.api.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
public class EndpointApplication {
	private static final Logger LOG = LoggerFactory.getLogger(EndpointApplication.class);

	private final Environment environment;

	@Autowired
	public EndpointApplication(Environment environment) {
		this.environment = environment;
	}

	@RequestMapping("/getMessage")
	public String getMessage() {
		LOG.info("App environment message: {}", environment.getProperty("instance.message"));
		return environment.getProperty("instance.message");
	}
}
