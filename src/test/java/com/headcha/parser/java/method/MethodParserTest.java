package com.headcha.parser.java.method;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.headcha.parser.java.JavaCodeFormatter;
import com.headcha.parser.java.method.MethodParser;
import com.headcha.parser.java.method.model.MethodInfo;
import com.headcha.util.LegacyCodeUtil;

public class MethodParserTest {

	@Test
	public void testMethodParser_일반적인메서드_라인넘버_테스트() throws Exception {
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getMethodInfoCode());
		MethodParser methodParser = new MethodParser(legacy);
		
		MethodInfo methodInfo = methodParser.getMethodInfoList().get(0);
		
		assertEquals(methodInfo.getStartLine(), 11);
		assertEquals(methodInfo.getBodyStartLine(), 12);
		
		assertEquals(methodInfo.getBodyEndLine(), 35);
		assertEquals(methodInfo.getEndLine(), 36);
		assertEquals(methodInfo.getTotalBodyLine(), 24);
	}
	
	@Test
	public void testMethodParser_어노테이션메서드_라인넘버_테스트() throws Exception {
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getAnotationMethodInfoCode());
		MethodParser methodParser = new MethodParser(legacy);
		MethodInfo methodInfo = methodParser.getMethodInfoList().get(0);
		
		assertEquals(methodInfo.getStartLine(), 22);
		assertEquals(methodInfo.getEndLine(), 34);
		assertEquals(methodInfo.getBodyStartLine(), 23);
		
		assertEquals(methodInfo.getBodyEndLine(), 33);
		assertEquals(methodInfo.getTotalBodyLine(), 11);
		
	}
	
	@Test
	public void testMethodParser_바디스트링_테스트() throws Exception {
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getAnotationMethodInfoCode());
		MethodParser methodParser = new MethodParser(legacy);
		MethodInfo methodInfo = methodParser.getMethodInfoList().get(0);
			
		System.out.println(methodInfo.getBodyString());
		
	}
	
}
