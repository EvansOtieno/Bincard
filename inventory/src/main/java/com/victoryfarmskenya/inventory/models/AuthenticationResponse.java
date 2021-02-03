package com.victoryfarmskenya.inventory.models;

import lombok.Data;

public @Data class AuthenticationResponse {
	private final String jwt;
	private final Users user;
	
	public AuthenticationResponse(String jwt,Users user) {
		this.jwt=jwt;
		this.user=user;
	}

	public String getJwt() {
		return jwt;
	}

	public Users getUser() {
		return user;
	}

	
}