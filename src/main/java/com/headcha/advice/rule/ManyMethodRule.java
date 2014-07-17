package com.headcha.advice.rule;

import java.util.List;

import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.ManyMethod;
import com.headcha.parser.java.method.MethodParser;
import com.headcha.parser.java.method.model.MethodInfo;

class ManyMethodRule implements AdviceRule {
	private static final int MANY_METHOD_SIZE = 9;
	private static final ManyMethod NO_ADVICE = new ManyMethod();
	@Override
	public Advice checkRule(String legacyCode) {
		List<MethodInfo> methodList = createMethodList(legacyCode);
		
		if (methodList.isEmpty())
			return NO_ADVICE;
		
		if (methodList.size() < MANY_METHOD_SIZE)
			return NO_ADVICE;
		
		ManyMethod manyMethodAdvice = new ManyMethod();
		
		for (MethodInfo method : methodList) 
			manyMethodAdvice.addLegacyLineNumber(method.getStartLine());
		
		return manyMethodAdvice;
	}
	private List<MethodInfo> createMethodList(String legacyCode) {
		MethodParser methodParser = new MethodParser(legacyCode);
		List<MethodInfo> methodList = methodParser.getMethodInfoList();
		return methodList;
	}

}
