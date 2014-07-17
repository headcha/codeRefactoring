package com.headcha.advice.rule;

import org.apache.commons.lang3.StringUtils;

import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.SingleLineComments;
import com.headcha.common.util.StringUtil;
import com.headcha.parser.java.source.SourceParser;

/**
 * 한줄 주석은 소스 코드 옆에 달도록 어드바이스 한다
 * @author 차정현
 *
 */
class SingleLineCommentsRule implements AdviceRule {

	@Override
	public Advice checkRule(String legacyCode) {
		String[] legacyCodeArray = StringUtil.splitNewLine(legacyCode);
		Advice advice = new SingleLineComments();

		for (int indexI = 0; indexI < legacyCodeArray.length; indexI++) {
			String legacy = legacyCodeArray[indexI];
			
			if (StringUtils.isBlank(legacy))
				continue;
			
			if (SourceParser.isSingleLineCommants(legacy))
				advice.addLegacyLineNumber(indexI + 1);
		}
		
		return advice;
	}

	

}
