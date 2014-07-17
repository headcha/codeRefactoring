package com.headcha.advice.rule;

import com.headcha.advice.rule.model.Advice;

public interface AdviceRule {
	public Advice checkRule(String legacyCode);
}
