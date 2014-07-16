package com.nhn.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.AssertThrows;

import com.nhn.test.util.LegacyCodeUtil;

public class JavaSourceUtilTest {

	@Test
	public void testIsMethod_문자열이자바메소드인지_검사한다() throws Exception {
		String methodString = "public String test(int aa , String test) {";
		assertTrue(JavaSourceUtil.isMethodString(methodString));
	}

	@Test
	public void testIsMethod_공백이면false() throws Exception {
		String methodString = "";
		assertFalse(JavaSourceUtil.isMethodString(methodString));
	}

	@Test
	public void testIsMethod_비정상메서드문자열() throws Exception {
		String methodString = "iont statc";
		assertFalse(JavaSourceUtil.isMethodString(methodString));
	}

	@Test
	public void testIsMethod_비정상메서드문자열_글자수가5자미만() throws Exception {
		String methodString = "io";
		assertFalse(JavaSourceUtil.isMethodString(methodString));
	}

	@Test
	public void testIsMethod_문자열이자바메소드인지_검사한다_메소드형식이_아니라면_false() throws Exception {
		String methodString = "public String test";
		assertFalse(JavaSourceUtil.isMethodString(methodString));
	}

	@Test
	public void testGetParameterLength_파라메터갯수를_리턴한다() throws Exception {
		String methodString = "public String test(int aa , String test)";

		assertEquals(JavaSourceUtil.getParameterLength(methodString), 2);
	}

	@Test
	public void test_조건문인지검사() throws Exception {
		String conditionString = "if (test && advice)";
		assertTrue(JavaSourceUtil.isConditionalString(conditionString));
	}
	
	@Test
	public void test_조건문갯수검사() throws Exception {
		String conditionString = "if (test && advice)";
		assertEquals(JavaSourceUtil.getConditionalCount(conditionString), 2);
	}
	
	

}
