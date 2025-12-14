package com.personal.fda.dtos;

public class AuthResponse {

	private String token;

    public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResponse(String token) {
		super();
		this.token = token;
	}

    public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
        return token;
    }

	@Override
	public String toString() {
		return "AuthResponse [token=" + token + "]";
	}

}
