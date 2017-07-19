package com.seolgi.refactor.advice.rule;

import com.seolgi.refactor.advice.rule.model.Advice;

public interface AdviceRule {
	public Advice checkRule(String legacyCode);
}
