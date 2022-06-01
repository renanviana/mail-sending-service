package com.renzvi.mss.model;

import com.renzvi.mss.model.enumerator.ExtensionEnum;

public class Attachment {

	private String name;
	private String location;
	private ExtensionEnum extension;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ExtensionEnum getExtension() {
		return extension;
	}

	public void setExtension(ExtensionEnum extension) {
		this.extension = extension;
	}

}
