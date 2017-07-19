package com.seolgi.refactor.advice.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.parser.java.JavaCodeFormatter;
import org.junit.Test;

import com.seolgi.refactor.advice.rule.model.ManyParameter;
import com.seolgi.refactor.util.LegacyCodeUtil;

public class ManyParameterRuleTest {

	private AdviceRule adviceService = new ManyParameterRule();

	@Test
	public void testCheckRule() throws Exception {
		Advice actualAdvice = createActualAdvice();
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getLongParameterCode());
		Advice expectedsAdvice = adviceService.checkRule(legacy);

		assertTrue(expectedsAdvice.isAdvice());

		assertArrayEquals(expectedsAdvice.getLegacyLineNumberList().toArray(), actualAdvice.getLegacyLineNumberList().toArray());
	}

	private Advice createActualAdvice() {
		Advice actualAdvice = new ManyParameter();
		actualAdvice.addLegacyLineNumber(10);
		return actualAdvice;
	}

}
