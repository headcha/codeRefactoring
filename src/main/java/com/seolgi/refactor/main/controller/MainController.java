package com.seolgi.refactor.main.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	private AtomicInteger count = new AtomicInteger(20000);
	
	@RequestMapping("/")
	public String index(Model model) {
		int totalCount = count.addAndGet(1);
		model.addAttribute("totalCount", totalCount);
		return "main/main";
	}
}
