package com.headcha.advice.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.headcha.advice.rule.AdviceRule;
import com.headcha.advice.rule.StaticFieldRule;
import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.StaticField;
import com.headcha.parser.java.JavaCodeFormatter;
import com.headcha.util.LegacyCodeUtil;

public class StaticFieldRuleTest {
	AdviceRule adviceService = new StaticFieldRule();
	
	@Test
	public void testCheckDeepNaestion_static_이면서_final이아닌필드의라인을가져온다() throws Exception {
		
		Advice actualAdvice = createActualAdvice();
		
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getStaticFieldCode());
		Advice expectedsAdvice = adviceService.checkRule(legacy);
		
		assertTrue(expectedsAdvice.isAdvice());
		assertArrayEquals(expectedsAdvice.getLegacyLineNumberList().toArray(), actualAdvice.getLegacyLineNumberList().toArray());
	}

	private Advice createActualAdvice() {
		Advice actualAdvice = new StaticField();
		actualAdvice.addLegacyLineNumber(10);
		actualAdvice.addLegacyLineNumber(11);
		return actualAdvice;
	}

}
