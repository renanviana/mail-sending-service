package com.renzvi.mss.model;

import java.util.List;

public class FileQuery {

	private String name;
	private List<Attachment> results;
	private ConditionalQuery conditional;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Attachment> getResults() {
		return results;
	}

	public void setResults(List<Attachment> results) {
		this.results = results;
	}

	public ConditionalQuery getConditional() {
		return conditional;
	}

	public void setConditional(ConditionalQuery conditional) {
		this.conditional = conditional;
	}

}
