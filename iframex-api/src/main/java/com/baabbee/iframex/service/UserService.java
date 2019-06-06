package com.baabbee.iframex.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.beans.User;
import com.baabbee.iframex.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		//userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}
	
	public void addUser(User user) {
		user.setCreatedDate(new Date());
		userRepository.save(user);		
	}
	
	public void updateUser(Long id, User user) {
		user.setLastModifiedDate(new Date());
		userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
