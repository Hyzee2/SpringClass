package com.digi.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarketController {
	
	@RequestMapping("/list")
	public String showList() {
		return "list";
	}
	
	@RequestMapping("/cart")
	public String showCart() {
		return "cart";
	}
}
