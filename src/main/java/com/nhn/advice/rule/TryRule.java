package com.nhn.advice.rule;

import org.apache.commons.lang3.StringUtils;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.TryAdvice;
import com.nhn.common.util.StringUtil;

/**
 * tryCatch블럭을 검사해 어드바이스 한다
 * 
 * @author 차정현
 * 
 */
class TryRule implements AdviceRule {

	public Advice checkRule(String legacyCode) {
		if (hasNotTryCatch(legacyCode))
			return new TryAdvice();
		
		String[] legacyCodeArray = StringUtil.splitNewLine(legacyCode);

		boolean isTryBlock = false;
		Advice advice = new TryAdvice();
		int tryBlockCodeCount = 0;
		
		for (int lineIndex = 0; lineIndex < legacyCodeArray.length; lineIndex++) {
			String legacy = legacyCodeArray[lineIndex].trim();
			
			if (StringUtils.isEmpty(legacy))
				continue;
			
			if (legacy.startsWith("try")) {
				isTryBlock = true;
				continue;
			}
			
			if (legacy.startsWith("} catch")) {
				isTryBlock = false;
				appendLegacyLineNumber(advice , lineIndex , tryBlockCodeCount);
				tryBlockCodeCount = 0;
				continue;
			}
			
			if (isTryBlock) 
				tryBlockCodeCount++;

		}

		return advice;
	}

	private void appendLegacyLineNumber(Advice advice, int lineIndex, int tryBlockCodeCount) {
		if (tryBlockCodeCount < 2)
			return;
		
		int startLineNumber = lineIndex - tryBlockCodeCount;
		for (int indexI = startLineNumber; indexI < lineIndex; indexI++) {
			advice.addLegacyLineNumber(indexI  + 1);
		}
		
	}

	private boolean hasNotTryCatch(String legacyCode) {
		return legacyCode.contains("try") == false && legacyCode.contains("catch") == false;
	}
}
