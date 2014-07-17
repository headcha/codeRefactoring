package com.headcha.advice.rule;

import java.util.List;

import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.StaticField;
import com.headcha.parser.java.field.FieldParser;
import com.headcha.parser.java.field.model.FieldInfo;

class StaticFieldRule implements AdviceRule {

	@Override
	public Advice checkRule(String legacy) {
		
		FieldParser fieldParser = new FieldParser(legacy);
		List<FieldInfo> fieldInfoList = fieldParser.getFieldInfoList();
		Advice writableStatic = new StaticField();
		
		for (FieldInfo field : fieldInfoList) 
			if (field.isWritableStatic())
				writableStatic.addLegacyLineNumber(field.getLineNumber());
		
		return writableStatic;
	}
}
