package com.headcha.advice.rule;

import org.junit.Test;

import com.headcha.advice.rule.ManyFieldRule;
import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.ManyField;
import com.headcha.util.LegacyCodeUtil;

import static org.hamcrest.Matcher.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
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
