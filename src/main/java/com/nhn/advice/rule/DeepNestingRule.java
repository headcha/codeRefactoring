package com.nhn.advice.rule;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.DeepNesting;
import com.nhn.common.util.StringUtil;
import com.nhn.parser.java.method.MethodParser;
import com.nhn.parser.java.method.model.MethodInfo;

/**
 * 코드 중첩여부를 검사해 어드바이스 한다.
 * 
 * @author 차정현
 * 
 */
class DeepNestingRule implements AdviceRule {
	/**
	 * 코드의 중첩을 검사해 중첩이 시작된 코드와 끝나는 코드의 어드바이스를 리턴한다.
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
