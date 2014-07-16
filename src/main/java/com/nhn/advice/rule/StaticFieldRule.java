package com.nhn.advice.rule;

import java.util.List;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.StaticField;
import com.nhn.parser.java.field.FieldParser;
import com.nhn.parser.java.field.model.FieldInfo;

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
