package com.nhn.advice.rule;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nhn.advice.rule.TryRule;
import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.DeepNesting;
import com.nhn.common.util.JavaCodeFormatter;
import com.nhn.test.util.LegacyCodeUtil;

public class TryRuleTest {
	TryRule adviceService = new TryRule();
	@Test
		public void testCheckRule_try블럭안에있는소스코드의_라인넘버를_기록한다() throws Exception {
	
			Advice actualAdvice = createActualAdvice();

			String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getTryLegacyCode());
			Advice expectedsAdvice = adviceService.checkRule(legacy);
	
			assertTrue(expectedsAdvice.isAdvice());
			
			assertArrayEquals(expectedsAdvice.getLegacyLineNumberList().toArray(), actualAdvice.getLegacyLineNumberList().toArray());
			
		}

	private Advice createActualAdvice() {
		Advice actualAdvice = new DeepNesting();
		actualAdvice.addLegacyLineNumber(12);
		actualAdvice.addLegacyLineNumber(13);
		actualAdvice.addLegacyLineNumber(14);
		actualAdvice.addLegacyLineNumber(15);
		actualAdvice.addLegacyLineNumber(16);
		actualAdvice.addLegacyLineNumber(17);
		actualAdvice.addLegacyLineNumber(18);

		actualAdvice.addLegacyLineNumber(24);
		actualAdvice.addLegacyLineNumber(25);
		actualAdvice.addLegacyLineNumber(26);
		actualAdvice.addLegacyLineNumber(27);
		actualAdvice.addLegacyLineNumber(28);
		actualAdvice.addLegacyLineNumber(29);
		actualAdvice.addLegacyLineNumber(30);
		return actualAdvice;
	}

}