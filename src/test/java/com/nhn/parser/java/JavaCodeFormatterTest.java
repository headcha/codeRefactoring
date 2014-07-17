package com.nhn.parser.java;

import org.junit.Test;

import com.nhn.parser.java.JavaCodeFormatter;
import com.nhn.test.util.LegacyCodeUtil;

public class JavaCodeFormatterTest {

	@Test
	public void testReFormat() throws Exception {
		String refomatCode = JavaCodeFormatter.reFormat(LegacyCodeUtil.getLongMethodCode());
		System.out.println(refomatCode);
	}

}
