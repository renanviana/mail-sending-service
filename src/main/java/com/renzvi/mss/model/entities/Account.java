package com.renzvi.mss.model.entities;

import com.renzvi.mss.model.enumerator.MailTypeEnum;

public class Account extends Entity {

	private String username;
	private String email;
	private String password;
	private MailTypeEnum mailTypeEnum;

	public Account() {
	}
	
	public Account(String uuid) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MailTypeEnum getMailTypeEnum() {
		return mailTypeEnum;
	}

	public void setMailTypeEnum(String mailTypeEnum) {
		this.mailTypeEnum = MailTypeEnum.get(mailTypeEnum);;
	}

}
