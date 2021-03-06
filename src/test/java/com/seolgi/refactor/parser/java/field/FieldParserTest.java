package com.seolgi.refactor.parser.java.field;

import java.util.List;

import com.seolgi.refactor.util.LegacyCodeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

import com.seolgi.refactor.parser.java.field.model.FieldInfo;

public class FieldParserTest {
	
	@Test
	public void 클래스를파싱해_필드정보를리턴한다_리턴된_필드정보리스트는_필드의갯수와일치해야한다() throws Exception {
		FieldParser fieldParser = new FieldParser(LegacyCodeUtil.getManyFieldCode());
		List<FieldInfo> fieldInfoList = fieldParser.getFieldInfoList();
		assertEquals(fieldInfoList.size(), 12);
	}
	
	@Test
	public void 필드가_없어도_동작해야한다() throws Exception {
		FieldParser fieldParser = new FieldParser(LegacyCodeUtil.getCatchPringCode());
		List<FieldInfo> fieldInfoList = fieldParser.getFieldInfoList();
		assertEquals(fieldInfoList.size(), 0);
	}
}
