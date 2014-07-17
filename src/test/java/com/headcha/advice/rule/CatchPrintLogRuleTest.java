package com.headcha.advice.rule;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import com.headcha.advice.rule.CatchPrintLogRule;
import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.CatchPrintLog;
import com.headcha.parser.java.JavaCodeFormatter;
import com.headcha.util.LegacyCodeUtil;

public class CatchPrintLogRuleTest {
	CatchPrintLogRule adviceService = new CatchPrintLogRule();

	@Test
	public void testCheckRule() throws Exception {

		Advice actualAdvice = createActualAdvice();
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getCatchPringCode());
		Advice expectedsAdvice = adviceService.checkRule(legacy);

		assertTrue(expectedsAdvice.isAdvice());
		assertArrayEquals(expectedsAdvice.getLegacyLineNumberList().toArray(), actualAdvice.getLegacyLineNumberList().toArray());
	}
	
	@Test
	public void testCheckRule_catche_하는코드가없다면_어드바이스라인은0개여야한다() throws Exception {

		Advice actualAdvice = createActualAdvice_빈어드바이스객체();

		Advice expectedsAdvice = adviceService.checkRule(LegacyCodeUtil.getCatchPrintCodeType2());
		
		assertFalse(expectedsAdvice.isAdvice());
		assertArrayEquals(expectedsAdvice.getLegacyLineNumberList().toArray(), actualAdvice.getLegacyLineNumberList().toArray());

	}

	private Advice createActualAdvice_빈어드바이스객체() {
		Advice actualAdvice = new CatchPrintLog();

		return actualAdvice;
	}
	
	private Advice createActualAdvice() {
		Advice actualAdvice = new CatchPrintLog();
		actualAdvice.addLegacyLineNumber(20);
		actualAdvice.addLegacyLineNumber(21);
		actualAdvice.addLegacyLineNumber(34);
		actualAdvice.addLegacyLineNumber(35);

		return actualAdvice;
	}
}
