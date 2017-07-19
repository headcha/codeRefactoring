package com.seolgi.refactor.advice.rule;

import java.util.List;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.advice.rule.model.StaticField;
import com.seolgi.refactor.parser.java.field.FieldParser;
import com.seolgi.refactor.parser.java.field.model.FieldInfo;

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
