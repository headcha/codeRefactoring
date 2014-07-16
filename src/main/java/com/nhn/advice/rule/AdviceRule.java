package com.nhn.advice.rule;

import com.nhn.advice.rule.model.Advice;

public interface AdviceRule {
	public Advice checkRule(String legacyCode);
}
