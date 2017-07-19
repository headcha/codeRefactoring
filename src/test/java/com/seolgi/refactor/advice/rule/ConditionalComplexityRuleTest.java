package com.seolgi.refactor.advice.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import com.seolgi.refactor.parser.java.JavaCodeFormatter;
import org.junit.Test;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.advice.rule.model.DeepNesting;
import com.seolgi.refactor.util.LegacyCodeUtil;

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
