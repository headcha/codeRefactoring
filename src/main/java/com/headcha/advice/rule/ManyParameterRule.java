package com.headcha.advice.rule;

import java.util.ArrayList;
import java.util.List;

import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.ManyParameter;
import com.headcha.parser.java.method.MethodParser;
import com.headcha.parser.java.method.model.MethodInfo;

/**
 * 파라메터 갯수를 체크해 어드바이스 한다
 * 
 * @author 차정현
 * 
 */
class ManyParameterRule implements AdviceRule {
	private static final int LONG_PARAMETER_SIZE = 3;
	/**
	 * 메소드 파라메터 갯수를 체크해 어드바이스 한다
	 * 
	 * @param legacyCode
	 * @return
	 */
	public Advice checkRule(String legacyCode) {
		List<MethodInfo> longParameterMethodList = filterLongParameterMethodList(legacyCode);
		Advice advice = new ManyParameter();
		addpendLegacyLine(longParameterMethodList, advice);

		return advice;
	}

	private void addpendLegacyLine(List<MethodInfo> longParameterMethodList, Advice advice) {
		for (MethodInfo method : longParameterMethodList)
			advice.addLegacyLineNumber(method.getStartLine());
	}

	private List<MethodInfo> filterLongParameterMethodList(String legacyCode) {
		MethodParser methodParser = new MethodParser(legacyCode);
		List<MethodInfo> methodInfoList = methodParser.getMethodInfoList();
		List<MethodInfo> longLineMethodList = new ArrayList<MethodInfo>();

		for (MethodInfo longLineMethod : methodInfoList)
			if (longLineMethod.getParameterSize() > LONG_PARAMETER_SIZE)
				longLineMethodList.add(longLineMethod);
		
		return longLineMethodList;
	}
}
