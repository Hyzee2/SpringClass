package com.digi.market.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digi.market.command.CListCommand;
import com.digi.market.command.Command;
import com.digi.market.command.MListCommand;


@Controller
public class MarketController {
	
	Command command = null;
	
	@RequestMapping("/list")
	public String showList() {
		return "list";
	}
	
	@RequestMapping("/listAdd")
	public String listAdd(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new MListCommand();
		command.execute(model);
		
		return "redirect:cart";
	}
	
	@RequestMapping("/cart")
	public String showCart(Model model) {
		command = new CListCommand();
		command.execute(model);
		
		return "cart";
	}
}
