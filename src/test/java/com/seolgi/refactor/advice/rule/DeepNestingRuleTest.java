package com.seolgi.refactor.advice.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.parser.java.JavaCodeFormatter;
import com.seolgi.refactor.util.LegacyCodeUtil;
import org.junit.Test;

import com.seolgi.refactor.advice.rule.model.DeepNesting;

public class DeepNestingRuleTest {
	
	private DeepNestingRule adviceService = new DeepNestingRule();
	
	@Test
	public void testCheckDeepNaestion_소스코드의중첩레벨이_tab_이4번이상_되는코드가3줄이상이라면_코드라인을기록한다() throws Exception {
		
		Advice actualAdvice = createActualAdvice();
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getDeepNestingCode());
		System.out.println(legacy);
		Advice expectedAdvice = adviceService.checkRule(legacy);
		adviceService.checkRule2(legacy);
		System.out.println(expectedAdvice.getLegacyLineNumberList());
		assertTrue(expectedAdvice.isAdvice());
		
		assertArrayEquals(expectedAdvice.getLegacyLineNumberList().toArray(), actualAdvice.getLegacyLineNumberList().toArray());
	}

	private Advice createActualAdvice() {
		Advice actualAdvice = new DeepNesting();
		actualAdvice.addLegacyLineNumber(14);
		actualAdvice.addLegacyLineNumber(15);
		actualAdvice.addLegacyLineNumber(16);
		
		actualAdvice.addLegacyLineNumber(24);
		actualAdvice.addLegacyLineNumber(25);
		
		actualAdvice.addLegacyLineNumber(34);
		actualAdvice.addLegacyLineNumber(35);
		actualAdvice.addLegacyLineNumber(36);
		
		actualAdvice.addLegacyLineNumber(38);
		actualAdvice.addLegacyLineNumber(39);
		actualAdvice.addLegacyLineNumber(40);
		return actualAdvice;
	}
}
