package com.devtool.test.controller;

import org.springframework.web.bind.annotation.*;


public class ThymeleafController {

	@GetMapping("/about")
	//@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about()
	{
		System.out.println("Inside about handler..."+"\n"+"Just For Testing the Thymeleaf Working..");
		return "about";
		//about.html
	}
}
