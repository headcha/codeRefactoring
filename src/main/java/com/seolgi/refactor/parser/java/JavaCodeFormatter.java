package com.seolgi.refactor.parser.java;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import com.google.googlejavaformat.java.JavaFormatterOptions;

public class JavaCodeFormatter {
	public static String reFormat(String source)  {

		try {
			return new Formatter(JavaFormatterOptions.builder().build()).formatSource(source);
		} catch (FormatterException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
