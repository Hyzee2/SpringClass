package kr.soft.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.soft.study.dto.UDto;
import kr.soft.study.user.command.Command;
import kr.soft.study.user.command.UJoinCommand;
import kr.soft.study.user.command.ULoginCommand;

@Controller
@RequestMapping("/user")
public class UController {
	
	Command command = null;
	
	@RequestMapping("/login") // �α��� �������� ������ 
	public String confirmLogin() {
		return "user/loginForm";
	}
	
	@RequestMapping("/loginConfirm") // �α��� ó�� 
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, UDto udto) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		System.out.println("������� ����!");
		command = new ULoginCommand();
		command.execute(model);
		return "redirect:main";
	}
	
	@RequestMapping("/logout") // �α׾ƿ� ó�� 
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("�α׾ƿ� �Ϸ�");
		return "redirect:main";
	}
	
	@RequestMapping("/joinForm") // ȸ������ �������� ������ 
	public String userJoin() {
		return "user/userJoin";
	}
	
	@RequestMapping("/joinConfirm") // ȸ������ ó�� 
	public String confirmJoin(HttpServletRequest request, Model model, UDto udto, BindingResult result) {
		System.out.println("ȸ������ ��ȿ�� �˻� ����");
		String page = "main";
		
		UserValidator validator = new UserValidator();
		validator.validate(udto, result);
		if(result.hasErrors()) {
			page = "joinForm";
		}else {
			model.addAttribute("request", request);
			command = new UJoinCommand();
			command.execute(model);
		}
		return "redirect:"+page;
	}
	
	@RequestMapping("/main")
	public String main() {
		return "user/main";
	}

}
