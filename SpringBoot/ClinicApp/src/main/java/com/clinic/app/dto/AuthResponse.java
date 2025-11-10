package com.clinic.app.dto;

import com.clinic.app.entities.Role;

public class AuthResponse {
	private String token;
    private Long id;
    private String email;
    private Role role;
    
	public AuthResponse(String token, Long id, String email, Role role) {
		super();
		this.token = token;
		this.id = id;
		this.email = email;
		this.role = role;
	}
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
    
    
}
