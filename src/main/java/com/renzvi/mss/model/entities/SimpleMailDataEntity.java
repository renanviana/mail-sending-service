package com.renzvi.mss.model.entities;

public class SimpleMailDataEntity extends Entity {

	private String username;
	private String email;

	public SimpleMailDataEntity() {
	}

	public SimpleMailDataEntity(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
