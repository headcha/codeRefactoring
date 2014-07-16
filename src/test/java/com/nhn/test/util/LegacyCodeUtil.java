package com.nhn.test.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class LegacyCodeUtil {
	public static String getTryLegacyCode() {
		return readStringToFIle("src/test/resources/java/TryLegacy.java");
	}

	public static String getDeepNestingCode() {
		return readStringToFIle("src/test/resources/java/DeepNestingLegacy.java");
	}

	public static String getCatchPringCode() {
		return readStringToFIle("src/test/resources/java/CatchPrintLegacy.java");
	}

	public static String getLongParameterCode() {
		return readStringToFIle("src/test/resources/java/LongParameterLegacy.java");
	}
	
	public static String getConditionalComplexityCode() {
		return readStringToFIle("src/test/resources/java/ConditionalComplexityLegacy.java");
	}
	
	public static String getStaticFieldCode()  {
		return readStringToFIle("src/test/resources/java/StaticFieldLegacy.java");
	}
	
	public static String getPublicFieldCode()  {
		return readStringToFIle("src/test/resources/java/PublicFieldLegacy.java");
	}
	
	public static String getThreeMethodCode()  {
		return readStringToFIle("src/test/resources/java/PublicFieldLegacy.java");
	}
	
	public static String getLongMethodCode()  {
		return readStringToFIle("src/test/resources/java/LongMethodLegacy.java");
	}
	
	public static String getSingleLineCommentsCode()  {
		return readStringToFIle("src/test/resources/java/SingleLineCommentsLegacy.java");
	}
	
	public static String getCatchPrintCodeType2()  {
		return readStringToFIle("src/test/resources/java/CatchPrintLegacyType2.java");
	}
	
	public static String getReFormatCode()  {
		return readStringToFIle("src/test/resources/java/ReformatLegacy.java");
	}
	
	public static String getMethodInfoCode()  {
		return readStringToFIle("src/test/resources/java/MethodInfoLegacy.java");
	}
	
	public static String getAnotationMethodInfoCode() {
		return readStringToFIle("src/test/resources/java/MethodInfoLegacy_anotationLegacy.java");
	}
	
	private static String readStringToFIle(String filePath) {
		try {
			return FileUtils.readFileToString(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getManyFieldCode() {
		return readStringToFIle("src/test/resources/java/ManyFieldLegacy.java");
	}
	
	public static String getShotNameFieldCode(){
		return readStringToFIle("src/test/resources/java/ShotFieldLegacy.java");
	}
	
	public static String getShotNameMethodCode(){
		return readStringToFIle("src/test/resources/java/ShotMethodLegacy.java");
	}
	
	public static String getManyMethodCode(){
		return readStringToFIle("src/test/resources/java/ManyMethodLegacy.java");
	}

}
