package com.renzvi.mss.model.enumerator;

public enum ConditionalTypeEnum {

	OR("OR", "or");

	private String name;
	private String value;

	ConditionalTypeEnum(String name, String value) {
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
