package com.nhn.advice.rule;

import org.apache.commons.lang3.StringUtils;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.CatchPrintLog;
import com.nhn.common.util.StringUtil;

class CatchPrintLogRule implements AdviceRule {

	@Override
	public Advice checkRule(String legacyCode) {
		if (hasNotTryCatch(legacyCode))
			return new CatchPrintLog();

		String[] legacyCodeArray = StringUtil.splitNewLine(legacyCode);
		Advice advice = appendLegacyLine(legacyCodeArray);

		return advice;
	}

	private Advice appendLegacyLine(String[] legacyCodeArray) {
		boolean isAdviceCheck = false;
		boolean isCatchInnerCode = false;
		String endString = null;

		Advice advice = new CatchPrintLog();

		for (int lineIndex = 0; lineIndex < legacyCodeArray.length; lineIndex++) {
			String legacy = legacyCodeArray[lineIndex].trim();

			if (StringUtils.isEmpty(legacy))
				continue;

			if (isCatchStart(legacy)) {
				isAdviceCheck = true;
				endString = extractedEndString(legacy);
				continue;
			}

			if (isAdviceCheck && isProcessPrintOnly(legacy))
				isCatchInnerCode = true;

			if (isCatchEnd(isAdviceCheck, endString, legacy)) {
				isCatchInnerCode = false;
				isAdviceCheck = false;
				continue;
			}

			if (isCatchInnerCode && isAdviceCheck && legacy.trim().startsWith("throw"))
				continue;

			if (isCatchInnerCode)
				advice.addLegacyLineNumber(lineIndex + 1);

		}
		return advice;
	}

	private boolean isCatchStart(String legacy) {
		return legacy.contains("} catch");
	}

	private boolean isCatchEnd(boolean isAdviceCheck, String endString, String legacy) {
		return isAdviceCheck && legacy.startsWith(endString);
	}

	private boolean isProcessPrintOnly(String legacy) {
		return legacy.contains("printStackTrace") || legacy.contains("log");
	}

	private static String extractedEndString(String legacy) {
		return legacy.split(" catch")[0];
	}

	private boolean hasNotTryCatch(String legacyCode) {
		return legacyCode.contains("try") == false && legacyCode.contains("catch") == false;
	}

}
