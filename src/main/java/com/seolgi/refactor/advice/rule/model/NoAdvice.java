package com.seolgi.refactor.advice.rule.model;

public class NoAdvice extends BaseAbstractAdvice {
	public NoAdvice() {
		type = this.getClass().getSimpleName();
	}

	@Override
	public boolean isAdvice() {
		return true;
	}
	
	
}
