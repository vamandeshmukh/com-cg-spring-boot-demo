package com.cg.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	private final Logger LOG = LoggerFactory.getLogger(Hello.class);

	@GetMapping("/hello")
	public String hello() {
		LOG.info("hello");
		return "Hello";
	}
}
