package com.headcha.advice.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.headcha.advice.rule.AdviceRule;
import com.headcha.advice.rule.ConditionalComplexityRule;
import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.DeepNesting;
import com.headcha.parser.java.JavaCodeFormatter;
import com.headcha.util.LegacyCodeUtil;

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
