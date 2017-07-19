package com.seolgi.refactor.code.service;

import org.junit.Test;

import static org.junit.Assert.*;
import com.seolgi.refactor.code.model.AdviceCollection;
import com.seolgi.refactor.util.LegacyCodeUtil;

public class CodeAdviceServiceTest {
	private CodeAdviceService adviceService = new CodeAdviceService();
	@Test
	public void testCheckAllRule_어드바이스할_대상이존재한다면_리턴되는JsonArray의Length는0보다크다() throws Exception {
		
		AdviceCollection adviceCollection = adviceService.checkAllRule(LegacyCodeUtil.getLongMethodCode());
		
		assertTrue(adviceCollection.getAdviceList().size() > 0);
	}
}
