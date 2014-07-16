package com.nhn.advice.rule.model;

public class NoAdvice extends BaseAbstractAdvice {
	public NoAdvice() {
		type = this.getClass().getSimpleName();
	}

	@Override
	public boolean isAdvice() {
		return true;
	}
	
	
}
