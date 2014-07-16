package com.nhn.advice.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.DeepNesting;
import com.nhn.common.util.JavaCodeFormatter;
import com.nhn.test.util.LegacyCodeUtil;

public class ConditionalComplexityRuleTest {
	AdviceRule adviceService = new ConditionalComplexityRule();
	
	@Test
		public void testCheckRule() throws Exception {
			Advice actualAdvice = createActualAdvice();
			String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getConditionalComplexityCode());
			Advice expectedsAdvice = adviceService.checkRule(legacy);

			assertTrue(expectedsAdvice.isAdvice());
			assertArrayEquals(expectedsAdvice.getLegacyLineNumberList().toArray(), actualAdvice.getLegacyLineNumberList().toArray());
		}

	private Advice createActualAdvice() {
		Advice actualAdvice = new DeepNesting();
		actualAdvice.addLegacyLineNumber(13);
		return actualAdvice;
	}
}
