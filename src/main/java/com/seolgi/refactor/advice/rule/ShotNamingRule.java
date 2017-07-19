package com.seolgi.refactor.advice.rule;

import java.util.List;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.advice.rule.model.ShotNaming;
import com.seolgi.refactor.parser.java.field.FieldParser;
import com.seolgi.refactor.parser.java.field.model.FieldInfo;
import com.seolgi.refactor.parser.java.method.MethodParser;
import com.seolgi.refactor.parser.java.method.model.MethodInfo;

/**
 * 필드나 메서드 명이 너무 짫은지 검사
 * @author 차정현
 *
 */
class ShotNamingRule implements AdviceRule {
	
	@Override
	public Advice checkRule(String legacyCode) {
		ShotNaming shotNamingAdvice = new ShotNaming();
		
		shouldShotFieldNameWithAddLegacyLineNumber(shotNamingAdvice, legacyCode);
		shouldShotMethodNameWihdAddLegacyLineNumber(shotNamingAdvice , legacyCode);	
		
		return shotNamingAdvice;
	}

	/**
	 * 메서드명을 검사해 6자 이하의 이름이라면 라인 넘버를 기록한다
	 * @param shotNamingAdvice
	 * @param legacyCode
	 */
	private void shouldShotMethodNameWihdAddLegacyLineNumber(ShotNaming shotNamingAdvice, String legacyCode) {
		MethodParser methodParser = new MethodParser(legacyCode);
		List<MethodInfo> methodInfoList = methodParser.getMethodInfoList();
		
		if (methodInfoList.isEmpty())
			return;
		
		for (MethodInfo methodInfo : methodInfoList)
			if (methodInfo.isShotName())
				shotNamingAdvice.addLegacyLineNumber(methodInfo.getStartLine());
	}

	/**
	 * 필드 명을 검사해 4자 이하의 이름이라면 라인 넘버를 기록한다
	 * @param shotNamingAdvice
	 * @param legacyCode
	 */
	private void shouldShotFieldNameWithAddLegacyLineNumber(ShotNaming shotNamingAdvice, String legacyCode) {
		FieldParser fieldParser = new FieldParser(legacyCode);
		List<FieldInfo> fieldInfoList = fieldParser.getFieldInfoList();
		
		if (fieldInfoList.isEmpty())
			return;
		
		for (FieldInfo fieldInfo : fieldInfoList)
			if (fieldInfo.isShotName())
				shotNamingAdvice.addLegacyLineNumber(fieldInfo.getLineNumber());
		
	}
	
}
