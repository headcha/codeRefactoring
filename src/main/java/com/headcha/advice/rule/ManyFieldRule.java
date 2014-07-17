package com.headcha.advice.rule;

import java.util.ArrayList;
import java.util.List;

import com.headcha.advice.rule.model.Advice;
import com.headcha.advice.rule.model.ManyField;
import com.headcha.parser.java.field.FieldParser;
import com.headcha.parser.java.field.model.FieldInfo;

/**
 * 너무 많은 멤버변수를 가지고 있는지 검사
 * 
 * @author 차정현
 * 
 */
class ManyFieldRule implements AdviceRule {
	private static final int MANY_FIELD_SIZE = 9;
	private static final ManyField NO_ADVICE = new ManyField();
	
	@Override
	public Advice checkRule(String legacyCode) {
		List<FieldInfo> fieldInfoList = createFieldList(legacyCode);

		if (fieldInfoList.size() == 0)
			return NO_ADVICE;

		List<FieldInfo> memberFieldList = removeStaticField(fieldInfoList);
		
		if (memberFieldList.size() < MANY_FIELD_SIZE)
			return  NO_ADVICE;

		Advice manyFieldAdvice = new ManyField();
		
		for (FieldInfo memberField : memberFieldList) 
			manyFieldAdvice.addLegacyLineNumber(memberField.getLineNumber());
		
		return manyFieldAdvice;
	}

	private List<FieldInfo> createFieldList(String legacyCode) {
		FieldParser fieldParser = new FieldParser(legacyCode);
		List<FieldInfo> fieldInfoList = fieldParser.getFieldInfoList();
		return fieldInfoList;
	}

	private List<FieldInfo> removeStaticField(List<FieldInfo> fieldInfoList) {
		List<FieldInfo> filterFieldList = new ArrayList<FieldInfo>();

		for (FieldInfo field : fieldInfoList) 
			if (field.isStatic() == false)
				filterFieldList.add(field);
		
		return filterFieldList;
	}
}
