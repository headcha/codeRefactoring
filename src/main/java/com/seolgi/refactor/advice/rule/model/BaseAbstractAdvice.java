package com.seolgi.refactor.advice.rule.model;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAbstractAdvice implements Advice {
	protected List<Integer> legacyLineNumberList = new ArrayList<Integer>();

	protected String type;

	public List<Integer> getLegacyLineNumberList() {
		return legacyLineNumberList;
	}

	public void addLegacyLineNumber(int legacyLineNumber) {
		this.legacyLineNumberList.add(legacyLineNumber);
	}

	public boolean isAdvice() {
		return this.legacyLineNumberList.size() > 0;
	}

	public String getType() {
		return type;
	}
}
