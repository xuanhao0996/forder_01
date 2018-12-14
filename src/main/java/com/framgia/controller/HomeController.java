package com.framgia.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
	@RequestMapping("/")
	public String home() {
		
		return "/client/index";
	}
}
