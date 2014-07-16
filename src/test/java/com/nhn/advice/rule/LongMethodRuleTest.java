package com.nhn.advice.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.LongMethod;
import com.nhn.common.util.JavaCodeFormatter;
import com.nhn.test.util.LegacyCodeUtil;

public class LongMethodRuleTest {

	AdviceRule adviceService = new LongMethodRule();

	@Test
	public void testCheckRule() throws Exception {
		Advice expectedAdvice = createActualAdvice();
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getLongMethodCode());
		Advice actualAdvice = adviceService.checkRule(legacy);

		assertTrue(actualAdvice.isAdvice());
		
		assertArrayEquals(expectedAdvice.getLegacyLineNumberList().toArray(), actualAdvice.getLegacyLineNumberList().toArray());
		
	}
	
	

	private Advice createActualAdvice() {
		Advice actualAdvice = new LongMethod();

		for (int indexI = 23; indexI < 57; indexI++) {
			actualAdvice.addLegacyLineNumber(indexI);
		}

		return actualAdvice;
	}
}