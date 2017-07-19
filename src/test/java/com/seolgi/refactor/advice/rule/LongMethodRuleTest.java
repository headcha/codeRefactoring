package com.seolgi.refactor.advice.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.advice.rule.model.LongMethod;
import com.seolgi.refactor.parser.java.JavaCodeFormatter;
import com.seolgi.refactor.util.LegacyCodeUtil;
import org.junit.Test;

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