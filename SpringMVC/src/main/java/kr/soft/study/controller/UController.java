package kr.soft.study.controller;

import java.util.Map;

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
	
	@RequestMapping("/error")
	public String error(Model model) {
		model.addAttribute("error", "���� �غ� ���Դϴ�.");
		model.addAttribute("url", "main");
		return "message";
		
	}
	
	@RequestMapping("/login") // �α��� �������� ������ 
	public String confirmLogin() {
		return "user/loginForm";
	}
	
	@RequestMapping("/loginConfirm") // �α��� ó�� 
	public String login(HttpServletRequest request, HttpSession session, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("session", session);
		command = new ULoginCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		if(map.containsKey("error")) {
			model.addAttribute("error", map.get("error"));
			model.addAttribute("url", map.get("url"));
			return "message";
		}
		if(map.containsKey("admin")) {
			return "redirect:../admin/admin_main";
		}
		
		return "redirect:main";
	}
	
	@RequestMapping("/logout") // �α׾ƿ� ó�� 
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		System.out.println("�α׾ƿ� �Ϸ�");
		model.addAttribute("error", "�α׾ƿ� ó���Ǿ����ϴ�.");
		model.addAttribute("url", "main");
		return "message";
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
			model.addAttribute("error", "ȸ������ ���� �Դϴ�. ��Ȯ�� ������ �Է����ּ���.");
			model.addAttribute("url", "joinForm");
			return "message";
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
