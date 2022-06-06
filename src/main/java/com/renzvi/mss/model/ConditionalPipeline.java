package com.renzvi.mss.model;

import com.renzvi.mss.model.enumerator.ConditionalPipelineTypeEnum;

public class ConditionalPipeline {

	private String name;
	private ConditionalPipelineTypeEnum conditionalPipelineTypeEnum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConditionalPipelineTypeEnum getConditionalPipelineTypeEnum() {
		return conditionalPipelineTypeEnum;
	}

	public void setConditionalPipelineTypeEnum(ConditionalPipelineTypeEnum conditionalPipelineTypeEnum) {
		this.conditionalPipelineTypeEnum = conditionalPipelineTypeEnum;
	}

}
