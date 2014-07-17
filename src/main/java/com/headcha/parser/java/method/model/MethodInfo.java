package com.headcha.parser.java.method.model;

import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.expr.AnnotationExpr;
import japa.parser.ast.stmt.BlockStmt;

import java.util.List;

import com.headcha.common.util.StringUtil;

public class MethodInfo {
	private MethodDeclaration methodDeclaration;
	private String legacy;

	public static MethodInfo createBy(MethodDeclaration methodDeclaration, String legacy) {
		return new MethodInfo(methodDeclaration , legacy);
	}
	
	private MethodInfo (MethodDeclaration methodDeclaration, String legacy) {
		this.legacy = legacy;
		this.methodDeclaration = methodDeclaration;
	}

	public final int getBodyStartLine() {
		return methodDeclaration.getBody().getBeginLine() + 1;
	}

	public BlockStmt getBody() {
		return methodDeclaration.getBody();
	}
	
	public String getBodyString() {
		return createMethodBodyString();
	}

	private String createMethodBodyString() {
		StringBuilder builder = new StringBuilder();
		
		String[] legacyArray = StringUtil.splitNewLine(legacy);
		int totalBodyLineIndex = getTotalBodyLine();
		for (int indexI = 0; indexI < totalBodyLineIndex; indexI++) {
			int methodLineIndex = getStartLine() + indexI ;
			builder.append(legacyArray[methodLineIndex]);
			
			if (indexI < totalBodyLineIndex)
			builder.append("\n");
		}
		
		return builder.toString();
	}

	public final int getBodyEndLine() {
		return methodDeclaration.getEndLine() - 1;
	}
	
	public final int getEndLine() {
		return methodDeclaration.getEndLine();
	}



	public String getName() {
		return methodDeclaration.getName();
	}
	
	public boolean isShotName() {
		return this.getName().length() < 6; 
	}

	public int getParameterSize() {
		List<Parameter> parameters = methodDeclaration.getParameters();
		if (parameters == null)
			return 0;
		return parameters.size();
	}

	public int getTotalBodyLine() {
		return getBodyEndLine() - getStartLine();
	}

	public int getStartLine() {
		int annotationLength = getAnotationLineLength();
		
		return methodDeclaration.getBeginLine() + annotationLength;
	}

	private int getAnotationLineLength() {
		int annotationLength = 0;
		
		List<AnnotationExpr> annotationExprs =  methodDeclaration.getAnnotations();
		
		if (annotationExprs != null) {
			annotationLength = annotationExprs.size();
		}
		return annotationLength;
	}
}
