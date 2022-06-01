package com.renzvi.mss.model;

import com.renzvi.mss.model.enumerator.MailTypeEnum;

public class Account {

	private SimpleMailData simpleMailData;
	private String password;
	private MailTypeEnum mailTypeEnum;

	public SimpleMailData getSimpleMailData() {
		return simpleMailData;
	}

	public void setSimpleMailData(SimpleMailData simpleMailData) {
		this.simpleMailData = simpleMailData;
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

	public void setMailTypeEnum(MailTypeEnum mailTypeEnum) {
		this.mailTypeEnum = mailTypeEnum;
	}

}
