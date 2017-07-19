package com.seolgi.refactor.parser.java.source;

import org.apache.commons.lang3.StringUtils;

import com.seolgi.refactor.util.StringUtil;

public class SourceParser {

	private static final String AND_CONDITION_CHAR = "&&";
	private static final String OR_CONDITION_CHAR = "\\|\\|";
	private static final int MIN_CONDITIONAL_STRING = 5;
	
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


	public static boolean isMethodEndString(String legacy) {
		return legacy.startsWith("\t}");
	}
	
	public static boolean isSingleLineCommants(String legacy) {
		legacy = legacy.trim();
		return legacy.startsWith("//");
	}
}
