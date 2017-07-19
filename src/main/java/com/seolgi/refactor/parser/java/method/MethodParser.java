package com.seolgi.refactor.parser.java.method;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.seolgi.refactor.parser.java.method.model.MethodInfo;
import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.List;


public class MethodParser {
	
	private List<MethodInfo> methodInfoList = new ArrayList<MethodInfo>();
	private String legacy;
	
	public MethodParser(String legacy) {
		this.legacy = legacy;
		try {
			CompilationUnit compilationUnit = JavaParser.parse(legacy);
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
