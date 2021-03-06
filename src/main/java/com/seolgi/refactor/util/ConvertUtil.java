package com.seolgi.refactor.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

import com.seolgi.refactor.code.convertor.JsonConvertor;
import com.seolgi.refactor.code.model.Legacy;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class ConvertUtil {

	public static String convertInputStreamToString(InputStream inputStream) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, "UTF-8");
		return writer.toString();
	}

	public static JSONObject convertLegacyToJson(Legacy legacy) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("codeBody", legacy.getCodeBody());
		jsonObject.put("fileName", legacy.getFileName());
		jsonObject.put("adviceList", JsonConvertor.convertJsonArrayBy(legacy.getAdviceCollection()).toString());
		return jsonObject;
	}

	public static Iterator<MultipartFile> convertRequestToFileIterator(MultipartHttpServletRequest request) {
		List<MultipartFile> files = request.getFiles("codeFile");
		Iterator<MultipartFile> fileNameIterator = files.iterator();
		return fileNameIterator;
	}
}
