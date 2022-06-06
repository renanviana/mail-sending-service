package com.renzvi.mss.model.enumerator;

public enum MailTypeEnum {

	GMAIL("GMAIL", "gmail.com");

	private String name;
	private String value;

	MailTypeEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public static MailTypeEnum get(String name) {
		for (MailTypeEnum mailTypeEnum : values()) {
			if (mailTypeEnum.getName().equals(name)) {
				return mailTypeEnum;
			}
		}
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
}
