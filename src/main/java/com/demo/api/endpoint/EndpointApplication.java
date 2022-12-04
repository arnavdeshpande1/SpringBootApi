package com.demo.api.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class EndpointApplication {
	private static final Logger LOG = LoggerFactory.getLogger(EndpointApplication.class);

	private final Environment environment;
	private static String instanceId;

	@Autowired
	public EndpointApplication(Environment environment) {
		this.environment = environment;
		this.instanceId = UUID.randomUUID().toString();
	}

	@RequestMapping("/getMessage")
	public String getMessage() {
		LOG.info("App environment message: {}", environment.getProperty("instance.message"));
		LOG.info("App environment instanceId: {}", instanceId);
		return environment.getProperty("instance.message") + ":" + instanceId;
	}
}
