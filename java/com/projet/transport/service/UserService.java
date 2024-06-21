package com.projet.transport.service;

import com.projet.transport.model.User;

public interface UserService {

	public User findUserByJwtToken(String email) throws Exception;
	
}
