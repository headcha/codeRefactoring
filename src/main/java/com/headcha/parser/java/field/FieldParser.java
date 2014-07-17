package com.headcha.parser.java.field;

import java.util.ArrayList;
import java.util.List;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import org.apache.commons.io.IOUtils;

import com.headcha.parser.java.field.model.FieldInfo;

public class FieldParser {
	
	private List<FieldInfo> fieldInfoList = new ArrayList<FieldInfo>();
	
	public FieldParser(String legacy) {

		try {
			CompilationUnit compilationUnit = JavaParser.parse(IOUtils.toInputStream(legacy));
			new FieldVisitor().visit(compilationUnit, null);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} 
	}
	

	private class FieldVisitor extends VoidVisitorAdapter<Object> {
		@Override
		public void visit(FieldDeclaration fieldDeclaration, Object obj) {
			FieldInfo fieldInfo = FieldInfo.createBy(fieldDeclaration);
			fieldInfoList.add(fieldInfo);
		}
	}


	public List<FieldInfo> getFieldInfoList() {
		return fieldInfoList;
	}
}
