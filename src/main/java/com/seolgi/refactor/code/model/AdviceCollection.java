package com.seolgi.refactor.code.model;

import java.util.ArrayList;
import java.util.List;

import com.seolgi.refactor.advice.rule.model.Advice;
import com.seolgi.refactor.advice.rule.model.NoAdvice;

public class AdviceCollection {
	private List<Advice> adviceList;
	
	public void setAdviceList(List<Advice> adviceList) {
		this.adviceList = adviceList;
	}
	
	public List<Advice> getAdviceList() {
		List<Advice> resultAdvice = new ArrayList<Advice>();
		
		for (Advice advice : this.adviceList)
			if (advice.isAdvice())
				resultAdvice.add(advice);
		
		if (resultAdvice.isEmpty())
			resultAdvice.add(new NoAdvice());
		
		return resultAdvice;
	}
	
	
}
