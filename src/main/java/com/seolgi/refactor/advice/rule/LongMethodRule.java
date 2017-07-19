package com.seolgi.refactor.advice.rule;

import java.util.ArrayList;
import java.util.List;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.advice.rule.model.LongMethod;
import com.seolgi.refactor.parser.java.method.MethodParser;
import com.seolgi.refactor.parser.java.method.model.MethodInfo;

class LongMethodRule implements AdviceRule {

	private static final int LONG_METHOD_LINE = 15;

	public Advice checkRule(String legacyCode) {

		List<MethodInfo> longLineMethodList = filterLongLineMethodList(legacyCode);
		Advice advice = new LongMethod();
		addpendLegacyLine(longLineMethodList, advice);

		return advice;
	}

	private void addpendLegacyLine(List<MethodInfo> longLineMethodList, Advice advice) {
		for (MethodInfo method : longLineMethodList)
			for (int codeLineNumber = method.getBodyStartLine(); codeLineNumber <= method.getBodyEndLine(); codeLineNumber++)
				advice.addLegacyLineNumber(codeLineNumber);
	}

	private List<MethodInfo> filterLongLineMethodList(String legacyCode) {
		MethodParser methodParser = new MethodParser(legacyCode);
		List<MethodInfo> methodInfoList = methodParser.getMethodInfoList();
		List<MethodInfo> longLineMethodList = new ArrayList<MethodInfo>();

		for (MethodInfo longLineMethod : methodInfoList)
			if (longLineMethod.getTotalBodyLine() > LONG_METHOD_LINE)
				longLineMethodList.add(longLineMethod);
		
		return longLineMethodList;
	}

}