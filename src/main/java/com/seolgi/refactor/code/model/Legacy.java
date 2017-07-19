package com.seolgi.refactor.code.model;

import com.seolgi.refactor.parser.java.JavaCodeFormatter;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public class Legacy {
	private String codeBody;
	private String fileName;
	private AdviceCollection adviceCollection;
	public String getCodeBody() {
		return codeBody;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public AdviceCollection getAdviceCollection() {
		return adviceCollection;
	}
	public void setAdviceCollection(AdviceCollection adviceCollection) {
		this.adviceCollection = adviceCollection;
	}
	
	public static Legacy createFromMultipartFile(MultipartFile multipartFile) throws IOException {
		Legacy legacy = new Legacy();
		legacy.fileName = multipartFile.getOriginalFilename();
		String legacyCode = IOUtils.toString(multipartFile.getBytes(), "UTF-8");
		legacy.codeBody = JavaCodeFormatter.reFormat(legacyCode);
		return legacy;
	}
	
	public static Legacy createFromString(String legacyCode , String fileName) throws IOException {
		Legacy legacy = new Legacy();
		legacy.fileName = fileName;
		legacy.codeBody = JavaCodeFormatter.reFormat(legacyCode);
		return legacy;
	}
	
}
