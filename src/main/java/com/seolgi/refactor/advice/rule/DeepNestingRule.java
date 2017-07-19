package com.seolgi.refactor.advice.rule;

import java.util.List;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.advice.rule.model.DeepNesting;
import com.seolgi.refactor.util.StringUtil;
import com.seolgi.refactor.parser.java.method.MethodParser;
import com.seolgi.refactor.parser.java.method.model.MethodInfo;
import org.apache.commons.lang3.StringUtils;

/**
 * 코드 중첩여부를 검사해 어드바이스 한다.
 * 
 * @author 차정현
 * 
 */
class DeepNestingRule implements AdviceRule {
	/**
	 * 코드패턴중 tab 이 5번 사용된 코드는 뎁스가 깊은것으로 판단한다.
	 * 
	 * @param legacyCode
	 * @return
	 */
	public Advice checkRule(String legacyCode) {
		
		MethodParser methodParser = new MethodParser(legacyCode);
		List<MethodInfo> methodList = methodParser.getMethodInfoList();
		
		Advice advice = new DeepNesting();
		
		for (MethodInfo method : methodList) {
			
			String[] MethodCodeArray = StringUtil.splitNewLine(method.getBodyString());
			int methodStartLine = method.getBodyStartLine();
			
				for (int lineIndex = 0; lineIndex < MethodCodeArray.length; lineIndex++) {
					String legacy = MethodCodeArray[lineIndex];
				
				if (StringUtils.isBlank(legacy) || legacy.trim().equals("{") || legacy.trim().equals("}"))
					continue;
				
				if (legacy.startsWith("          "))
					advice.addLegacyLineNumber(methodStartLine + lineIndex);
			}
		}
		
		return advice;
	}
	
}
