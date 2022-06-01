package com.renzvi.mss.model.enumerator;

public enum ExtensionEnum {

	PDF("PDF", ".pdf");

	private String name;
	private String value;

	ExtensionEnum(String name, String value) {
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
