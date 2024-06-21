package com.projet.transport.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.projet.transport.model.Cart;
import com.projet.transport.model.USER_ROLE;
import com.projet.transport.model.User;
import com.projet.transport.repository.CartRepository;
import com.projet.transport.repository.UserRepository;
import com.projet.transport.request.LoginRequest;
import com.projet.transport.response.AuthResponse;
import com.projet.transport.service.CustomerUserDetailsService;

@RestController
@RequestMapping("/auth")

public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;
	
	@Autowired
	private CartRepository cartRepository;
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws Exception{
		
		User isEmailExist = userRepository.findByEmail(user.getEmail());
		
		if(isEmailExist != null) {
			throw new Exception("Email is already used");
		}
		
		User createdUser = new User();
		createdUser.setFirstName(user.getFirstName());
		createdUser.setLastName(user.getLastName());
		createdUser.setEmail(user.getEmail());
		createdUser.setRole(user.getRole());
		createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User savedUser = userRepository.save(createdUser);
		
		Cart cart = new Cart();
		
		cart.setCustomer(savedUser);
		cartRepository.save(cart);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setMessage("Register success");
		authResponse.setRole(savedUser.getRole());
		return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest){
		
		String username = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		
		Authentication authentication = authenticate(username,password);
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		String role = authorities.isEmpty()?null:authorities.iterator().next().getAuthority();
	
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setMessage("Login success");
		authResponse.setRole(USER_ROLE.valueOf(role));
				
		return new ResponseEntity<>(authResponse, HttpStatus.OK);
	}
	
	private Authentication authenticate (String username, String password) {
		UserDetails userDetails = customerUserDetailsService.loadUserByUsername(username);
		
		if (userDetails == null) {
			throw new BadCredentialsException("Invalid username");
		}
		
		if(passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid password");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}
}
