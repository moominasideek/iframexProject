package com.baabbee.iframex.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.beans.User;
import com.baabbee.iframex.repository.UserRepository;

@Service
public class FramexUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Calling loadUserByUsername for username = " + username);
		Optional<User> optionalUsers = userRepository.findByEmailId(username);
		optionalUsers
		.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers
				.map(FramexUserDetailsImpl::new).get();
	}

}
