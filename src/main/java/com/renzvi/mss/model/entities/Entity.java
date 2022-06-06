package com.renzvi.mss.model.entities;

public abstract class Entity {

	public static final String UUID = "uuid";

	protected String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
