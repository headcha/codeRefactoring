package com.nhn.main.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MainController {
	private AtomicInteger count = new AtomicInteger(500);
	
	@RequestMapping("/index")
	public ModelAndView main() {
		int totalCount = count.addAndGet(1);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main/main");
		modelAndView.addObject("totalCount", totalCount);
		return modelAndView;
	}
}
