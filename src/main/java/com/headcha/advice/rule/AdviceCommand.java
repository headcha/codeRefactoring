package com.headcha.advice.rule;


import java.util.ArrayList;
import java.util.List;

import com.headcha.advice.rule.model.Advice;

public class AdviceCommand {
	
	public static List<Advice> checkAllAdviceRule(String legacy) {
		List<Advice> adviceList = new ArrayList<Advice>();
		adviceList.add(new CatchPrintLogRule().checkRule(legacy));
		adviceList.add(new ConditionalComplexityRule().checkRule(legacy));
		adviceList.add(new DeepNestingRule().checkRule(legacy));
		adviceList.add(new LongMethodRule().checkRule(legacy));
		adviceList.add(new ManyParameterRule().checkRule(legacy));
		adviceList.add(new PublicFieldRule().checkRule(legacy));
		adviceList.add(new StaticFieldRule().checkRule(legacy));
		adviceList.add(new TryRule().checkRule(legacy));
		adviceList.add(new SingleLineCommentsRule().checkRule(legacy));
		adviceList.add(new ManyFieldRule().checkRule(legacy));
		adviceList.add(new ManyMethodRule().checkRule(legacy));
		adviceList.add(new ShotNamingRule().checkRule(legacy));
		
		return adviceList;
	}
	
}
