package com.nhn.advice.rule;

import org.apache.commons.lang3.StringUtils;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.ConditionalComplexity;
import com.nhn.common.util.StringUtil;
import com.nhn.parser.java.source.SourceParser;

class ConditionalComplexityRule implements AdviceRule {

	@Override
	public Advice checkRule(String legacyCode) {
		String[] legacyCodeArray = StringUtil.splitNewLine(legacyCode);

		Advice advice = new ConditionalComplexity();

		for (int lineIndex = 0; lineIndex < legacyCodeArray.length; lineIndex++) {
			String legacy = legacyCodeArray[lineIndex];

			if (StringUtils.isEmpty(legacy))
				continue;

			if (SourceParser.isConditionalString(legacy)) 
				if (SourceParser.getConditionalCount(legacy) > 1)
					advice.addLegacyLineNumber(lineIndex + 1);
			
		}

		return advice;
	}

}
