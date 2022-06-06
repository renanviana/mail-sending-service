package com.renzvi.mss.model;

import java.util.List;

public class Pipeline {

	private String name;
	private List<FileQuery> queries;
	private Template template;
	private ConditionalPipeline conditionalPipeline;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FileQuery> getQueries() {
		return queries;
	}

	public void setQueries(List<FileQuery> queries) {
		this.queries = queries;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public ConditionalPipeline getConditionalPipeline() {
		return conditionalPipeline;
	}

	public void setConditionalPipeline(ConditionalPipeline conditionalPipeline) {
		this.conditionalPipeline = conditionalPipeline;
	}

}
