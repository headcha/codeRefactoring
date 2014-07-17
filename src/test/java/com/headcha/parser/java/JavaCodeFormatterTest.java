package com.headcha.parser.java;

import org.junit.Test;

import com.headcha.parser.java.JavaCodeFormatter;
import com.headcha.util.LegacyCodeUtil;

public class JavaCodeFormatterTest {

	@Test
	public void testReFormat() throws Exception {
		String refomatCode = JavaCodeFormatter.reFormat(LegacyCodeUtil.getLongMethodCode());
		System.out.println(refomatCode);
	}

}
