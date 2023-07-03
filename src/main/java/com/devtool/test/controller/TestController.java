package com.devtool.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String test()
	{
		int a = 1;
		int b = 500;
		System.out.println("This Test Controller is for testing ,project working..");
		return "Result = " + (a+b);
		
	}
}
