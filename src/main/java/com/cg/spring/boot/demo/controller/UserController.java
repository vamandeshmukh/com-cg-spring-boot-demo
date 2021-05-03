package com.cg.spring.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.config.JwtUtil;
import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.service.UserService;

//@CrossOrigin(origins = "http://localhost:4201")
@CrossOrigin(origins = "*")
@RestController
public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserService userDetailsService;

	// test method, delete afterwards

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/hello")
	public String hello() {
		log.info("hello");
		return "Hello";
	}

	@PostMapping("/login") // 1
	public String login(@RequestBody AppUser myUser) {
		log.info("login");
		if (myUser.getUsername().equals(userDetailsService.loadUserByUsername(myUser.getUsername()).getUsername())
				&& myUser.getPassword().equals(userDetailsService.loadUserByUsername(null).getPassword())) {
			log.info("user authenticated");
			return jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(myUser.getUsername()));
		} else {
			return "thisIsNotTheValidToken";
		}

	}

}