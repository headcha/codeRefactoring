package com.headcha.advice.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.headcha.advice.rule.AdviceRule;
import com.headcha.advice.rule.LongMethodRule;
import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.LongMethod;
import com.headcha.parser.java.JavaCodeFormatter;
import com.headcha.util.LegacyCodeUtil;

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