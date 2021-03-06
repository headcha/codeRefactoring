package com.seolgi.refactor.advice.rule;

import com.seolgi.refactor.advice.rule.model.Advice;
import org.junit.Test;

import com.seolgi.refactor.advice.rule.model.ManyField;
import com.seolgi.refactor.util.LegacyCodeUtil;

import static org.junit.Assert.*;
public class ManyFieldRuleTest {
	private ManyFieldRule manyFieldRule = new ManyFieldRule();
	
	@Test
	public void 스태틱이아닌_필드의갯수가_8개이상이라면_어드바이스한다() throws Exception {
		Advice advice = manyFieldRule.checkRule(LegacyCodeUtil.getManyFieldCode());
		assertTrue(advice.isAdvice());
	}
	
	@Test
	public void 어드바이스가있을경우_개선대상_필드의_라인넘버가존재한다() throws Exception {
		Advice expectedAdvice = createDummyAdvice();
		Advice actualAdvice = manyFieldRule.checkRule(LegacyCodeUtil.getManyFieldCode());
		assertArrayEquals(expectedAdvice.getLegacyLineNumberList().toArray(), actualAdvice.getLegacyLineNumberList().toArray());
	}
	
	private Advice createDummyAdvice() {
		Advice dummyManyAdvice = new ManyField();
		dummyManyAdvice.addLegacyLineNumber(14);
		dummyManyAdvice.addLegacyLineNumber(15);
		dummyManyAdvice.addLegacyLineNumber(16);
		dummyManyAdvice.addLegacyLineNumber(17);
		dummyManyAdvice.addLegacyLineNumber(18);
		dummyManyAdvice.addLegacyLineNumber(19);
		dummyManyAdvice.addLegacyLineNumber(20);
		dummyManyAdvice.addLegacyLineNumber(21);
		dummyManyAdvice.addLegacyLineNumber(22);
		
		return dummyManyAdvice;
	}

}
