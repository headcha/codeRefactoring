package com.headcha.common.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.headcha.common.util.StringUtil;

public class StringUtilTest {

	@Test
	public void testSeparatedBySpaceCase_대문자와소문자가섞여있는문자가있을때_첫대문자를_제외한_나머지대문자앞에_공백을_넣어분리한다() throws Exception {
		String testString = "separatedBySpaceCase";
		String returnString = StringUtil.separatedBySpaceCase(testString);
		
		assertEquals(returnString, "separated By Space Case");
	}
	
	

}
