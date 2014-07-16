package com.nhn.code.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.nhn.code.model.Code;

@Service
public class ManyFieldLegacy {
	private static int staticTest;
	private static int staticTest1;
	private static int staticTest2;
	
	private int test;
	private int test1;
	private int test2;
	private int test3;
	private int test4;
	private int test5;
	private int test6;
	private int test7;
	private int test8;
	
	public JSONObject insertCodeStringWithCreateCodeStringJson(String codeBody , int test , int test , int test) {
		for (int indexI = 1; indexI < 10; indexI++) {
			for (int indexJ = 1; indexJ < 20; indexJ++) {
				if (indexI == indexJ) 
					System.out.println("테스트 코드");
				
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
