package com.renzvi.mss.model.enumerator;

public enum MailTypeEnum {

	GMAIL("Gmail", "gmail.com");

	private String name;
	private String value;

	MailTypeEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
}
