package com.seolgi.refactor.advice.rule;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.util.LegacyCodeUtil;
import org.junit.Test;

import com.seolgi.refactor.advice.rule.model.ManyMethod;

import static org.junit.Assert.*;

public class ManyMethodRuleTest {
	private AdviceRule manyMethodRuleService = new ManyMethodRule();
	
	@Test
	public void 메소드_갯수가_8개이상이라면_어드바이스한다() {
		Advice expectedAdvice = createManyMethodAdvice();
		Advice actualAdvice = manyMethodRuleService.checkRule(LegacyCodeUtil.getManyMethodCode());
		
		assertArrayEquals(expectedAdvice.getLegacyLineNumberList().toArray(), actualAdvice.getLegacyLineNumberList().toArray());
	}

	private Advice createManyMethodAdvice() {
		Advice expectedAdvice = new ManyMethod();
		expectedAdvice.addLegacyLineNumber(10);
		expectedAdvice.addLegacyLineNumber(41);
		expectedAdvice.addLegacyLineNumber(72);
		expectedAdvice.addLegacyLineNumber(103);
		expectedAdvice.addLegacyLineNumber(134);
		expectedAdvice.addLegacyLineNumber(165);
		
		expectedAdvice.addLegacyLineNumber(196);
		expectedAdvice.addLegacyLineNumber(227);
		expectedAdvice.addLegacyLineNumber(258);
		expectedAdvice.addLegacyLineNumber(289);
		expectedAdvice.addLegacyLineNumber(320);
		
		return expectedAdvice;
	}
}
