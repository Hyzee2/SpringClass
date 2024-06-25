package com.hospital.animal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.animal.users.service.Command;

@Controller
public class UsersController {
	
	Command command = null;
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("/login");
		return "users/login";
	}
	
	@RequestMapping("/join")
	public String join() {
		System.out.println("/join");
		return "users/join";
	}
}
