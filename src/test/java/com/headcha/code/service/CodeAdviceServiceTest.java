package com.headcha.code.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import com.headcha.code.model.AdviceCollection;
import com.headcha.code.service.CodeAdviceService;
import com.headcha.util.LegacyCodeUtil;

public class CodeAdviceServiceTest {
	private CodeAdviceService adviceService = new CodeAdviceService();
	@Test
	public void testCheckAllRule_어드바이스할_대상이존재한다면_리턴되는JsonArray의Length는0보다크다() throws Exception {
		
		AdviceCollection adviceCollection = adviceService.checkAllRule(LegacyCodeUtil.getLongMethodCode());
		
		assertTrue(adviceCollection.getAdviceList().size() > 0);
	}
}
