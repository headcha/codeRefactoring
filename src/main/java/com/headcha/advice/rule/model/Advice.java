package com.headcha.advice.rule.model;

import java.util.List;

public interface Advice {
	
	public List<Integer> getLegacyLineNumberList();

	public void addLegacyLineNumber(int legacyLineNumber);

	public boolean isAdvice();
	
	public String getType();
}
