package com.seolgi.refactor.parser.java.method;

import static org.junit.Assert.assertEquals;

import com.seolgi.refactor.parser.java.JavaCodeFormatter;
import com.seolgi.refactor.parser.java.method.model.MethodInfo;
import com.seolgi.refactor.util.LegacyCodeUtil;
import org.junit.Test;

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
		System.out.println(LegacyCodeUtil.getAnotationMethodInfoCode());
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getAnotationMethodInfoCode());
		System.out.println(legacy);
		MethodParser methodParser = new MethodParser(legacy);
		MethodInfo methodInfo = methodParser.getMethodInfoList().get(0);
		
		assertEquals(methodInfo.getStartLine(), 22);
		assertEquals(methodInfo.getEndLine(), 33);
		assertEquals(methodInfo.getBodyStartLine(), 21);
		
		assertEquals(methodInfo.getBodyEndLine(), 32);
		assertEquals(methodInfo.getTotalBodyLine(), 10);
		
	}
	
	@Test
	public void testMethodParser_바디스트링_테스트() throws Exception {
		String legacy = JavaCodeFormatter.reFormat(LegacyCodeUtil.getAnotationMethodInfoCode());
		MethodParser methodParser = new MethodParser(legacy);
		MethodInfo methodInfo = methodParser.getMethodInfoList().get(0);

		System.out.println(methodInfo.getBodyString());

		
	}
	
}
