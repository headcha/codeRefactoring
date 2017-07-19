package com.seolgi.refactor.parser.java.method.model;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.seolgi.refactor.util.StringUtil;

import java.util.List;

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
		return methodDeclaration.getBegin().get().line + 1;
	}

	public BlockStmt getBody() {
		return methodDeclaration.getBody().get();
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
		return methodDeclaration.getEnd().get().line - 1;
	}
	
	public final int getEndLine() {
		return methodDeclaration.getEnd().get().line;
	}



	public String getName() {
		return methodDeclaration.getNameAsString();
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
		
		return methodDeclaration.getBegin().get().line + annotationLength;
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
