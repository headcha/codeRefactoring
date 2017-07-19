package com.seolgi.refactor.parser.java.field.model;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.FieldDeclaration;

import java.util.EnumSet;

public class FieldInfo {
	
	private FieldDeclaration fieldDeclaration;
	
	private FieldInfo(FieldDeclaration fieldDeclaration) {
		this.fieldDeclaration = fieldDeclaration;
	}
	
	public static FieldInfo createBy(FieldDeclaration fieldDeclaration) {
		return new FieldInfo(fieldDeclaration);
	}
	
	public boolean isStatic() {
		return this.getModifier().stream().anyMatch(modifier -> modifier.equals(Modifier.STATIC));
	}
	
	public boolean isWritableStatic() {
		return isStatic() && isNotFinal();
	}

	private boolean isNotFinal() {
		return this.getModifier().stream().anyMatch(modifier -> modifier.equals(Modifier.FINAL)) == false;
	}

	private EnumSet<Modifier> getModifier() {
		return fieldDeclaration.getModifiers();
	}

	public int getLineNumber() {
		return fieldDeclaration.getBegin().get().line;
	}

	public String getFieldName() {
		String[] fieldStructure = fieldDeclaration.toString().split(" ");
		return fieldStructure[fieldStructure.length - 1].split(";")[0];
	}
	
	public boolean isShotName() {
		return getFieldName().length() <= 4;
	}

	public boolean isPublic() {
		return this.getModifier().stream().anyMatch(modifier -> modifier.equals(Modifier.PUBLIC));
	}
}
