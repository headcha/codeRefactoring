package com.nhn.advice.rule;

import org.junit.Test;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.ManyMethod;
import com.nhn.test.util.LegacyCodeUtil;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

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
