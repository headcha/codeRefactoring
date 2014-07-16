package com.nhn.parser.java.field.model;

import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.ModifierSet;

public class FieldInfo {
	
	private FieldDeclaration fieldDeclaration;
	
	private FieldInfo(FieldDeclaration fieldDeclaration) {
		this.fieldDeclaration = fieldDeclaration;
	}
	
	public static FieldInfo createBy(FieldDeclaration fieldDeclaration) {
		return new FieldInfo(fieldDeclaration);
	}
	
	public boolean isStatic() {
		return ModifierSet.isStatic(this.getModifier());
	}
	
	public boolean isWritableStatic() {
		return isStatic() && isNotFinal();
	}

	private boolean isNotFinal() {
		return ModifierSet.isFinal(this.getModifier()) == false;
	}

	public int getModifier() {
		return fieldDeclaration.getModifiers();
	}

	public int getLineNumber() {
		return fieldDeclaration.getBeginLine();
	}

	public String getFieldName() {
		String[] fieldStructure = fieldDeclaration.toString().split(" ");
		return fieldStructure[fieldStructure.length - 1].split(";")[0];
	}
	
	public boolean isShotName() {
		return getFieldName().length() <= 4;
	}
}
