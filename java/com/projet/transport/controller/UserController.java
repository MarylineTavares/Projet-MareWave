package com.projet.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.transport.model.User;
import com.projet.transport.service.UserService;

@RestController
@RequestMapping("/api")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public ResponseEntity<User> findUserByJwtTokens(@RequestHeader("Authorization")String jwt) throws Exception {
		
		User user = userService.findUserByJwtToken(jwt);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
