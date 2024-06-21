package com.projet.transport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.transport.model.User;
import com.projet.transport.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserByJwtToken(String email) throws Exception{
		
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			throw new Exception("user not found");
		}
		
		return user;
	}
}
