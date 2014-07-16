package com.nhn.parser.java.method;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.nhn.parser.java.method.model.MethodInfo;


public class MethodParser {
	
	private List<MethodInfo> methodInfoList = new ArrayList<MethodInfo>();
	private String legacy;
	
	public MethodParser(String legacy) {
		this.legacy = legacy;
		try {
			CompilationUnit compilationUnit = JavaParser.parse(IOUtils.toInputStream(legacy));
			new MethodVisitor().visit(compilationUnit, null);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} 
	}

	
	public List<MethodInfo> getMethodInfoList() {
		
		return this.methodInfoList;
	}
	

	private class MethodVisitor extends VoidVisitorAdapter<Object> {
		
		@Override
		public void visit(MethodDeclaration methodDeclaration, Object obj) {
			MethodInfo method = MethodInfo.createBy(methodDeclaration , legacy);
			methodInfoList.add(method);
		}
	}
}
