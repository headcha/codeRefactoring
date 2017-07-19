package com.seolgi.refactor.parser.java;

import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.TextEdit;

public class JavaCodeFormatter {
	public static String reFormat(String source) throws BadLocationException {
		Map<String, String> options = createFormeatterOption();
		final CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(options);
		final TextEdit edit = createTextEdit(source, codeFormatter);

		IDocument document = new Document(source);
		edit.apply(document);
		
		return document.get();
	}

	private static TextEdit createTextEdit(String source, final CodeFormatter codeFormatter) {
		final TextEdit edit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, // format
				source, // source to format
				0, // starting position
				source.length(), // length
				0, // initial indentation
				System.getProperty("line.separator"));
		return edit;
	}

	private static Map<String, String> createFormeatterOption() {
		@SuppressWarnings("unchecked")
		Map<String, String> options = DefaultCodeFormatterConstants.getEclipseDefaultSettings();

		options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_6);
		options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_6);
		options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_6);

		options.put(DefaultCodeFormatterConstants.FORMATTER_ALIGNMENT_FOR_ENUM_CONSTANTS, DefaultCodeFormatterConstants.createAlignmentValue(true, DefaultCodeFormatterConstants.WRAP_ONE_PER_LINE, DefaultCodeFormatterConstants.INDENT_ON_COLUMN));
		options.put(DefaultCodeFormatterConstants.FORMATTER_LINE_SPLIT, "400");
		return options;
	}
}
