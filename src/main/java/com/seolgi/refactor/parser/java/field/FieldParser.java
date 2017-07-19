package com.seolgi.refactor.parser.java.field;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.seolgi.refactor.parser.java.field.model.FieldInfo;
import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.List;

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
