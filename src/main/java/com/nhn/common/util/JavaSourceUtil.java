package com.nhn.common.util;

import org.apache.commons.lang3.StringUtils;

public class JavaSourceUtil {
	private static final int MIN_METHOAD_LENGTH = 8;
	private static final String AND_CONDITION_CHAR = "&&";
	private static final String OR_CONDITION_CHAR = "\\|\\|";
	
	private static final int MIN_CONDITIONAL_STRING = 5;
	
	public static boolean isMethodString(String legacy) {
		legacy = StringUtils.deleteWhitespace(legacy);
		
		if (StringUtils.isEmpty(legacy))
			return false;
		
		if (isNotMinMethodLength(legacy))
			return false;
		
		if (hasNotRequiredChar(legacy))
			return false;
		
		if (isLastCharNotSatisfiedBy(legacy))
			return false;
		
		if (isStartWithControlStatements(legacy))
			return false;
		
		return true;
	}
	
	
	/**
	 * 메서드 구문과 비슷한 자바 예약어중 시작구문이 for , if , try , catch 인지 검사한다.
	 * @param legacy
	 * @return
	 */
	private static boolean isStartWithControlStatements(String legacy) {
		return legacy.startsWith("for") || legacy.startsWith("if") || legacy.startsWith("try") || legacy.startsWith("catch");
	}
	
	private static boolean hasNotRequiredChar(String legacy) {
		return hasRequiredChar(legacy) == false;
	}
	
	/**
	 * 메서드의 최소 글자는 void a () { 로 공백 제거후 항상 8자 이상이다.
	 * @param legacy
	 * @return
	 */
	private static boolean isNotMinMethodLength(String legacy) {
		return legacy.length() < MIN_METHOAD_LENGTH;
	}

	/**
	 * 메소드는 반드시 () 문자를 포함한다.
	 * @param legacy
	 */
	private static boolean hasRequiredChar(String legacy) {
		return (legacy.indexOf("(") > 0 && legacy.indexOf(")") > 0);
	}
	
	/**
	 * 메서드 마지막 글자는 항상  { 여야 한다. 
	 * 단 주석이 있을 경우는 주석 전 마지막 문자가 { 여야 한다.
	 * @param legacy
	 * @return
	 */
	private static boolean isLastCharNotSatisfiedBy(String legacy) {
		legacy = legacy.split("//")[0];
		String lastChar = legacy.substring(legacy.length() - 1 , legacy.length());
		return lastChar.equals("{") == false;
	}

	public static boolean isConditionalString(String legacy) {
		if (StringUtils.isEmpty(legacy))
			return false;

		if (StringUtils.deleteWhitespace(legacy).length() < MIN_CONDITIONAL_STRING)
			return false;

		if (StringUtils.deleteWhitespace(legacy).startsWith("if("))
			return true;

		return false;
	}

	public static int getConditionalCount(String legacy) {
		int orConditionCount = StringUtil.getEqualStringCount(legacy, OR_CONDITION_CHAR);
		int andConditionCount = StringUtil.getEqualStringCount(legacy, AND_CONDITION_CHAR);

		return orConditionCount + andConditionCount + 1;
	}

	public static int getParameterLength(String method) {
		method = StringUtils.deleteWhitespace(method);
		
		int startParamChar = method.indexOf("(");
		int endParamChar = method.indexOf(")");
		method = method.substring(startParamChar , endParamChar);
		
		return method.split(",").length;
	}
	
	public static boolean isPublicFeild(String fieldString) {
		
		return fieldString.trim().startsWith("public");
	}

	public static boolean isStaticFeild(String fieldString) {
		return fieldString.contains("static");
	}
	
	public static boolean isNotFinalFeild(String fieldString) {
		return fieldString.contains("final") == false;
	}

	public static boolean isMethodEndString(String legacy) {
		return legacy.startsWith("\t}");
	}
	
	public static boolean isSingleLineCommants(String legacy) {
		legacy = legacy.trim();
		return legacy.startsWith("//");
	}
}
