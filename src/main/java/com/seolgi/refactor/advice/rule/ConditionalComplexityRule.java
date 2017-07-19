package com.seolgi.refactor.advice.rule;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.advice.rule.model.ConditionalComplexity;
import com.seolgi.refactor.util.StringUtil;
import com.seolgi.refactor.parser.java.source.SourceParser;

class ConditionalComplexityRule implements AdviceRule {

	@Override
	public Advice checkRule(String legacyCode) {
		String[] legacyCodeArray = StringUtil.splitNewLine(legacyCode);

		Advice advice = new ConditionalComplexity();

		for (int lineIndex = 0; lineIndex < legacyCodeArray.length; lineIndex++) {
			String singleLineCode = legacyCodeArray[lineIndex];

			if (SourceParser.isConditionalString(singleLineCode))
				if (SourceParser.getConditionalCount(singleLineCode) > 1)
					advice.addLegacyLineNumber(lineIndex + 1);
		}

		return advice;
	}

}
