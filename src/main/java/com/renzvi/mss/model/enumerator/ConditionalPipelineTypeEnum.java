package com.renzvi.mss.model.enumerator;

public enum ConditionalPipelineTypeEnum {

	UNIQUE("UNIQUE", "unique");

	private String name;
	private String value;

	ConditionalPipelineTypeEnum(String name, String value) {
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
