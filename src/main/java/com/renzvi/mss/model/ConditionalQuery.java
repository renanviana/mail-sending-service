package com.renzvi.mss.model;

import java.util.List;

import com.renzvi.mss.model.enumerator.ConditionalTypeEnum;
import com.renzvi.mss.model.enumerator.ExtensionEnum;

public class ConditionalQuery {

	private String name;
	private List<String> words;
	private ExtensionEnum extensionEnum;
	private ConditionalTypeEnum conditionalTypeEnum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public ExtensionEnum getExtensionEnum() {
		return extensionEnum;
	}

	public void setExtensionEnum(ExtensionEnum extensionEnum) {
		this.extensionEnum = extensionEnum;
	}

	public ConditionalTypeEnum getConditionalTypeEnum() {
		return conditionalTypeEnum;
	}

	public void setConditionalTypeEnum(ConditionalTypeEnum conditionalTypeEnum) {
		this.conditionalTypeEnum = conditionalTypeEnum;
	}

}
