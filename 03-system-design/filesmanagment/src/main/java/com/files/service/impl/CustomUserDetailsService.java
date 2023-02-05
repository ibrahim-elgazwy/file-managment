package com.files.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.files.domain.User;
import com.files.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
        User user = userRepository.findByEmail(userName)
        		.orElseThrow(() -> new UsernameNotFoundException("USER Not found: " + userName));

        return User.builder()
	        .email(user.getEmail())
	        .id(user.getId())
	        .firstname(user.getFirstname())
	        .lastname(user.getLastname())
	        .password(user.getPassword())
	        .role(user.getRole())
	        .build();
	}

}
