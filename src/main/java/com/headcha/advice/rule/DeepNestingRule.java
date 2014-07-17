package com.headcha.advice.rule;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.DeepNesting;
import com.headcha.common.util.StringUtil;
import com.headcha.parser.java.method.MethodParser;
import com.headcha.parser.java.method.model.MethodInfo;

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
				
				if (legacy.startsWith("\t\t\t\t\t")) 
					advice.addLegacyLineNumber(methodStartLine + lineIndex);
			}
		}
		
		return advice;
	}
	
}
