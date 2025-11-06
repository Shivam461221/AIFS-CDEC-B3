package com.clinic.app.services;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinic.app.configuration.JwtUtils;
import com.clinic.app.dto.AuthResponse;
import com.clinic.app.dto.LoginRequest;
import com.clinic.app.dto.RegisterUserRequest;
import com.clinic.app.entities.Role;
import com.clinic.app.entities.User;
import com.clinic.app.exception.ResourceNotFoundException;
import com.clinic.app.repos.UserRepository;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtils jwtUtils;

	public AuthResponse login(LoginRequest request) {
		
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		String token = jwtUtils.generateToken(userDetails, user.getRole().name(), user.getId());

		return new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
	}

	public AuthResponse register(RegisterUserRequest request) {

		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new RuntimeException("Email already exists!");
		}

		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());

		if (request.getRole() == Role.ROLE_RECEPTIONIST) {
			User doctor = userRepository.findById(request.getDoctorId())
					.orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
			user.setDoctor(doctor);
		}

		User savedUser = userRepository.save(user);

		String token = jwtUtils
				.generateToken(
						org.springframework.security.core.userdetails.User.withUsername(savedUser.getEmail())
								.password(savedUser.getPassword())
								.roles(savedUser.getRole().name().replace("ROLE_", "")).build(),
						savedUser.getRole().name(), savedUser.getId());

		return new AuthResponse(token, savedUser.getId(), savedUser.getEmail(), savedUser.getRole());
	}
}
