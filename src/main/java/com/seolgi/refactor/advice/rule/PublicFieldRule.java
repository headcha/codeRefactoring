package com.seolgi.refactor.advice.rule;

import java.util.List;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.advice.rule.model.PublicField;
import com.seolgi.refactor.parser.java.field.FieldParser;
import com.seolgi.refactor.parser.java.field.model.FieldInfo;

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