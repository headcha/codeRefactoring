package com.nhn.code.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.nhn.code.model.Code;

@Service
public class TryLegacy {
	public JSONObject insertCodeStringWithCreateCodeStringJson(String codeBody) {
		try {
			for (int indexI = 1; indexI < 10; indexI++) {
				for (int indexJ = 1; indexJ < 20; indexJ++) {
					if (indexI == indexJ) {
						System.out.println("테스트 코드");
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			for (int indexI = 1; indexI < 10; indexI++) {
				for (int indexJ = 1; indexJ < 20; indexJ++) {
					if (indexI == indexJ) {
						System.out.println("테스트 코드");
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		try {
			System.out.println("테스트 코드");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return codeStringJson;
	}
	
	

}
