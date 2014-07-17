package com.headcha.parser.java.source;

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

import com.headcha.parser.java.source.SourceParser;
import com.headcha.util.LegacyCodeUtil;

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
