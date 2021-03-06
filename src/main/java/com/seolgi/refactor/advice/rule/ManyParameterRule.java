package com.seolgi.refactor.advice.rule;

import java.util.ArrayList;
import java.util.List;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.advice.rule.model.ManyParameter;
import com.seolgi.refactor.parser.java.method.MethodParser;
import com.seolgi.refactor.parser.java.method.model.MethodInfo;

/**
 * 파라메터 갯수를 체크해 어드바이스 한다
 * 
 * @author 차정현
 * 
 */
class ManyParameterRule implements AdviceRule {
	private static final int LONG_PARAMETER_SIZE = 5;
	/**
	 * 메소드 파라메터 갯수를 체크해 어드바이스 한다
	 * 
	 * @param legacyCode
	 * @return
	 */
	public Advice checkRule(String legacyCode) {
		List<MethodInfo> longParameterMethodList = filterLongParameterMethodList(legacyCode);
		Advice advice = new ManyParameter();
		appendLegacyLine(longParameterMethodList, advice);

		return advice;
	}

	private void appendLegacyLine(List<MethodInfo> longParameterMethodList, Advice advice) {
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
