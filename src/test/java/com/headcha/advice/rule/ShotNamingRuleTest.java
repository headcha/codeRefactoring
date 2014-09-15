package com.headcha.advice.rule;

import org.eclipse.jface.text.BadLocationException;
import org.junit.Test;

import static org.junit.Assert.*;
import com.headcha.advice.rule.AdviceRule;
import com.headcha.advice.rule.ShotNamingRule;
import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.ShotNaming;
import com.headcha.parser.java.JavaCodeFormatter;
import com.headcha.util.LegacyCodeUtil;


public class ShotNamingRuleTest {
	private AdviceRule adviceService = new ShotNamingRule();
	
	@Test
	public void 소스코드의_필드명이_짧다면_라인넘버를_기록한다() throws BadLocationException{
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getShotNameFieldCode());
		Advice expectedsAdvice = adviceService.checkRule(legacy);
		
		assertArrayEquals(expectedsAdvice.getLegacyLineNumberList().toArray(), createLegacyFieldAdvice().getLegacyLineNumberList().toArray());
	}
	
	private Advice createLegacyFieldAdvice() {
		Advice actualAdvice = new ShotNaming();
		actualAdvice.addLegacyLineNumber(10);
		actualAdvice.addLegacyLineNumber(11);
		
		return actualAdvice;
	}
	
	@Test
	public void 소스코드의_메서드명이_짧다면_라인넘버를_기록한다() throws BadLocationException{
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getShotNameMethodCode());
		Advice expectedsAdvice = adviceService.checkRule(legacy);
		
		assertArrayEquals(expectedsAdvice.getLegacyLineNumberList().toArray(), createLegacyMethodAdvice().getLegacyLineNumberList().toArray());
	}
	
	private Advice createLegacyMethodAdvice() {
		Advice actualAdvice = new ShotNaming();
		actualAdvice.addLegacyLineNumber(11);
		actualAdvice.addLegacyLineNumber(42);
		
		return actualAdvice;
	}
}
