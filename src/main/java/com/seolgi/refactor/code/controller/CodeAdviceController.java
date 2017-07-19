package com.seolgi.refactor.code.controller;

import java.io.IOException;
import java.util.Iterator;

import com.seolgi.refactor.code.model.Legacy;
import com.seolgi.refactor.code.service.CodeAdviceService;
import com.seolgi.refactor.util.ConvertUtil;
import org.eclipse.jface.text.BadLocationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/code")
public class CodeAdviceController {
	@Autowired
	private CodeAdviceService codeAdviceService;

	@RequestMapping(value = "/adviceToFile", method = RequestMethod.POST)
	@ResponseBody
	public String adviceToFile(MultipartHttpServletRequest request) throws IOException, JSONException, BadLocationException {
		Iterator<MultipartFile> fileNameIterator = ConvertUtil.convertRequestToFileIterator(request);
		return appendAdviceJsonArray(fileNameIterator).toString();
	}

	private JSONArray appendAdviceJsonArray(Iterator<MultipartFile> fileNameIterator) throws IOException, BadLocationException, JSONException {
		JSONArray adviceJsonArray = new JSONArray();

		while (fileNameIterator.hasNext()) {
			MultipartFile multipartFile = fileNameIterator.next();
			Legacy legacy = Legacy.createFromMultipartFile(multipartFile);
			legacy.setAdviceCollection(codeAdviceService.checkAllRule(legacy.getCodeBody()));
			
			JSONObject jsonObject = ConvertUtil.convertLegacyToJson(legacy);
			adviceJsonArray.put(jsonObject);
		}
		
		return adviceJsonArray;
	}


	@RequestMapping(value = "/adviceToString", method = RequestMethod.POST)
	@ResponseBody
	public String adviceToString(String legacyCode, String fileName) throws IOException, JSONException, BadLocationException {
		Legacy legacy = Legacy.createFromString(legacyCode, fileName);
		legacy.setAdviceCollection(codeAdviceService.checkAllRule(legacy.getCodeBody()));
		return ConvertUtil.convertLegacyToJson(legacy).toString();
	}
}
