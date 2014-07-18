package com.nhn.common.util;


public class StringUtil {
	
	public static String separatedBySpaceCase(String value) {
		char[] valueCharArray = value.toCharArray();
		StringBuilder result = new StringBuilder();
		for (int indexI = 0; indexI < valueCharArray.length; indexI++) {
			char charValue = valueCharArray[indexI];

			if (Character.isUpperCase(charValue)) {
				result.append(" ");
			}

			result.append(charValue);
		}

		return result.toString();
	}

	public static int getEqualStringCount(String originString, String searchString) {
		String temp[] = originString.split(searchString);
		
		return temp.length -  1;
	}
	
	public static String[] splitNewLine(String value) {
		return value.split("\n");
	}
}
