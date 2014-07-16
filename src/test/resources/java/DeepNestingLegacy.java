package com.nhn.code.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.nhn.code.model.Code;

@Service
public class DeepNestingLegacy {
	public JSONObject insertCodeStringWithCreateCodeStringJson(String codeBody) {
		for (int indexI = 1; indexI < 10; indexI++) {
			for (int indexJ = 1; indexJ < 20; indexJ++) {
				if (indexI == indexJ) {
					System.out.println("테스트 코드");
					System.out.println("테스트 코드");
					System.out.println("테스트 코드");
				}
			}
		}
		
		for (int indexI = 1; indexI < 10; indexI++) {
			for (int indexJ = 1; indexJ < 20; indexJ++) {
				if (indexI == indexJ) {
					System.out.println("테스트 코드");
					System.out.println("테스트 코드");
				}
			}
		}
		
		for (int indexI = 1; indexI < 10; indexI++) {
			for (int indexJ = 1; indexJ < 20; indexJ++) {
				if (indexI == indexJ) {
					
					System.out.println("테스트 코드");
					System.out.println("테스트 코드");
					System.out.println("테스트 코드");
					
					System.out.println("테스트 코드");
					System.out.println("테스트 코드");	
					System.out.println("테스트 코드");	
				}
			}
		}
		return codeStringJson;
	}
	
	

}
