package org.ram.service;

import org.ram.model.User;
import org.ram.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void registerUser(User user) {
	userRepository.save(user);
		
	}

	public User fetchUser(String username) {
	
		return userRepository.findByUsername(username);
	}
	
}
