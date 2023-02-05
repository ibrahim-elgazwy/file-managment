package com.files.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.files.domain.User;
import com.files.enums.PermissionLevel;
import com.files.enums.Role;
import com.files.repository.PermissionRepository;
import com.files.repository.UserRepository;
import com.files.rest.request.AuthenticationRequest;
import com.files.rest.request.RegisterRequest;
import com.files.rest.response.AuthenticationResponse;
import com.files.security.JwtService;
import com.files.service.PermissionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository repository;
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final PermissionRepository permissionRepository;
	private final PermissionService permissionService;

	public AuthenticationResponse register(RegisterRequest request) throws Exception {

		var user = User.builder().firstname(request.getFirstname()).lastname(request.getLastname())
				.email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
				.role(request.getRole()).build();

		user = repository.save(user);
		
		permissionService.creatUserPermissions(user);

		var jwtToken = jwtService.generateToken(user);

		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		var user = userDetailsService.loadUserByUsername(request.getEmail());

		var jwtToken = jwtService.generateToken(user);

		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public static boolean isAdminUser() {

		var authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		return authorities.stream()
				.anyMatch(authority -> authority.toString()
						.equals(Role.ADMIN.toString()));
	}
	
	public static String getLoginUserEmail() {

		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public boolean hasEditPrivillages() {
		
		return permissionRepository.findByUserEmail(getLoginUserEmail())
				.filter(permission -> permission
						.getPermissionLevel().toString()
						.equals(PermissionLevel.EDIT.toString()))
				.isPresent();
	}
}
