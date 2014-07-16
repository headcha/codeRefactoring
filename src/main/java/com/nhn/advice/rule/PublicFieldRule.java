package com.nhn.advice.rule;

import org.apache.commons.lang3.StringUtils;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.PublicField;
import com.nhn.common.util.JavaSourceUtil;
import com.nhn.common.util.StringUtil;

class PublicFieldRule implements AdviceRule {

	@Override
	public Advice checkRule(String legacy) {
		
		String[] lecacyArray = StringUtil.splitNewLine(legacy);
		Advice advice = new PublicField();
		
		for (int lineIndex = 0; lineIndex < lecacyArray.length; lineIndex++) {
			String legacyCode = lecacyArray[lineIndex];
			
			if (isBeforeFieldString(legacyCode))
				continue;
			
			if (JavaSourceUtil.isMethodString(legacyCode)) 
				break;
			
			if (JavaSourceUtil.isPublicFeild(legacyCode))
				advice.addLegacyLineNumber(lineIndex + 1);
		}
		
		return advice;
	}
	
	private boolean isBeforeFieldString(String legacyCode) {
		legacyCode = StringUtils.trim(legacyCode);
		return StringUtils.isEmpty(legacyCode) || legacyCode.startsWith("import") || legacyCode.startsWith("package") || legacyCode.startsWith("@") || legacyCode.contains("class");
	}

}