package com.clinic.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.app.dto.AuthResponse;
import com.clinic.app.dto.LoginRequest;
import com.clinic.app.dto.RegisterUserRequest;
import com.clinic.app.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	 @Autowired
	    private AuthService authService;

	    // ✅ Public Login API
	    @PostMapping("/login")
	    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
	        return ResponseEntity.ok(authService.login(request));
	    }

	    // ✅ Only Admin can register a doctor or receptionist
	    @PreAuthorize("hasRole('ADMIN')")
	    @PostMapping("/register")
	    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterUserRequest request) {
	        return ResponseEntity.ok(authService.register(request));
	    }
	    
//	    @PostMapping("/register")
//	    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterUserRequest request,
//	                                                 Authentication auth) {
//	        System.out.println(">>> Auth in controller: " + auth);
//	        if (auth != null) {
//	            System.out.println(">>> Name: " + auth.getName());
//	            System.out.println(">>> Authorities: " + auth.getAuthorities());
//	        }
//	        return ResponseEntity.ok(authService.register(request));
//	    }

}
