package com.nhn.code.service;

import java.io.IOException;
import static org.apache.commons.io.IOUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nhn.code.convertor.JsonConvertor;
import com.nhn.code.model.AdviceCollection;
import com.nhn.code.model.Code;

@Service
public class DeepNestingLegacy {
	public static String test;
	public static String test2;
	private static final String test3;
	
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

	private JSONObject createResponseJson(String legacy, AdviceCollection adviceCollection) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("codeBody", legacy);
		jsonObject.put("adviceList", JsonConvertor.convertJsonArrayBy(adviceCollection).toString());
	}
	
	
	public JSONObject insertCodeStringWithCreateCodeStringJson(String codeBody) {
		for (int indexI = 1; indexI < 10; indexI++) {
			for (int indexJ = 1; indexJ < 20; indexJ++) {
				if (indexI == indexJ) {
					System.out.println("테스트 코드");
				}
			}
		}
		
		for (int indexI = 1; indexI < 10; indexI++) {
			for (int indexJ = 1; indexJ < 20; indexJ++) {
				if (indexI == indexJ) {
					System.out.println("테스트 코드");
				}
			}
		}
		
		for (int indexI = 1; indexI < 10; indexI++) {
			for (int indexJ = 1; indexJ < 20; indexJ++) {
				if (indexI == indexJ) {
					System.out.println("테스트 코드");
				}
			}
		}
		return codeStringJson;
	}
	
	

}
