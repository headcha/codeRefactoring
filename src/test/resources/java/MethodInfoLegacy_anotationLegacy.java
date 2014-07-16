package com.nhn.code.service;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nhn.code.model.AdviceCollection;
import com.nhn.code.model.Code;

@Service
public class DeepNestingLegacy {
	
	@RequestMapping("/adviceToFile")
	@ResponseBody
	public String adviceToFile(@RequestParam("codeFile") MultipartFile file) throws IOException, JSONException {
		
		if(file.isEmpty()) 
		
			return null;
		
		String legacy = IOUtils.toString(file.getInputStream());
		
		AdviceCollection adviceCollection = codeAdviceService.checkAllRule(legacy);
		
		JSONObject jsonObject = createResponseJson(legacy, adviceCollection);
		return jsonObject.toString();
	}
	
}
