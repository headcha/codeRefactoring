package com.nhn.advice.rule;

import java.util.List;

import com.nhn.advice.rule.model.Advice;
import com.nhn.advice.rule.model.PublicField;
import com.nhn.parser.java.field.FieldParser;
import com.nhn.parser.java.field.model.FieldInfo;

class PublicFieldRule implements AdviceRule {

	@Override
	public Advice checkRule(String legacy) {
		FieldParser fieldParser = new FieldParser(legacy);
		List<FieldInfo> fieldInfoList = fieldParser.getFieldInfoList();
		Advice advice = new PublicField();
		
		for (FieldInfo field : fieldInfoList)
			if (field.isPublic()) 
				advice.addLegacyLineNumber(field.getLineNumber());
		return advice;
	}
	
	

}