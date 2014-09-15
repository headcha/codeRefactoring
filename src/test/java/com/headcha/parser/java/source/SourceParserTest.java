package com.headcha.parser.java.source;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SourceParserTest {



	@Test
	public void test_조건문인지검사() throws Exception {
		String conditionString = "if (test && advice)";
		assertTrue(SourceParser.isConditionalString(conditionString));
	}
	
	@Test
	public void test_조건문갯수검사() throws Exception {
		String conditionString = "if (test && advice)";
		assertEquals(SourceParser.getConditionalCount(conditionString), 2);
	}
	
	

}
