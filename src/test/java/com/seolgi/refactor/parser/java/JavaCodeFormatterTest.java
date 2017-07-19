package com.seolgi.refactor.parser.java;

import org.junit.Test;

import com.seolgi.refactor.util.LegacyCodeUtil;

public class JavaCodeFormatterTest {

	@Test
	public void testReFormat() throws Exception {
		String refomatCode = JavaCodeFormatter.reFormat(LegacyCodeUtil.getLongMethodCode());
		System.out.println(refomatCode);
	}

}
