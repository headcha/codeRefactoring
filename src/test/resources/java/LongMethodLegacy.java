package com.nhn.advice.rule;

import org.apache.commons.lang3.StringUtils;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.CatchPrintLog;
import com.nhn.common.util.StringUtil;

public class CatchThrowRule implements AdviceRule {

    @Override
	public Advice appendAdvice(String legacyCode) {
		if (hasNotTryCatch(legacyCode))
			return new CatchPrintLog();

		String[] legacyCodeArray = StringUtil.splitNewLine(legacyCode);
		Advice advice = appendLegacyLine(legacyCodeArray);

		return advice;
	}

	private Advice appendLegacyLine(String[] legacyCodeArray) {
		boolean isAdviceCheck = false;
		boolean isAppend = false;
		String endString = null;

		Advice advice = new CatchPrintLog();

		for (int lineIndex = 0; lineIndex < legacyCodeArray.length; lineIndex++) {
			String legacy = legacyCodeArray[lineIndex].trim();
			
			if (StringUtils.isEmpty(legacy))
				continue;

			if (legacy.contains("} catch")) {
				isAdviceCheck = true;
				endString = extractedEndString(legacy);
				continue;
			}

			if (isAdviceCheck)
				if (legacy.contains("throw"))
					isAppend = true;

			if (isAdviceCheck && legacy.startsWith(endString)) {
				isAppend = false;
				isAdviceCheck = false;
				continue;
			}

			if (isAppend) {
				advice.addLegacyLineNumber(lineIndex + 1);
			}

		}
		return advice;
	}

	private static String extractedEndString(String legacy) {
		return legacy.split(" catch")[0];
	}

	private boolean hasNotTryCatch(String legacyCode) {
		return legacyCode.contains("try") == false && legacyCode.contains("catch") == false;
	}

}
