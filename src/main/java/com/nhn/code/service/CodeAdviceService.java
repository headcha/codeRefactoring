package com.nhn.code.service;

import org.springframework.stereotype.Service;

import com.nhn.advice.rule.AdviceRule;
import com.nhn.advice.rule.AdviceCommand;
import com.nhn.advice.rule.model.Advice;
import com.nhn.code.model.AdviceCollection;

/**
 * 어드바이스 룰 서비스
 * @author 차정현
 *
 */
@Service
public class CodeAdviceService {
	/**
	 * 등록된 모든 룰을 체크해 어드바이스 컬렉션을 생성한다.
	 * @param legacy 코드
	 * @return 어드바이스 컬렉션
	 */
	public AdviceCollection checkAllRule(String legacy) {
		AdviceCollection adviceCollection = new AdviceCollection();
		adviceCollection.setAdviceList(AdviceCommand.checkAllAdviceRule(legacy));
		
		return adviceCollection;
		
	}
}
