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
		model.addAttribute("error", "서비스 준비 중입니다.");
		model.addAttribute("url", "main");
		return "message";
		
	}
	
	@RequestMapping("/login") // 로그인 페이지를 보여줌 
	public String confirmLogin() {
		return "user/loginForm";
	}
	
	@RequestMapping("/loginConfirm") // 로그인 처리 
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
	
	@RequestMapping("/logout") // 로그아웃 처리 
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		System.out.println("로그아웃 완료");
		model.addAttribute("error", "로그아웃 처리되었습니다.");
		model.addAttribute("url", "main");
		return "message";
	}
	
	@RequestMapping("/joinForm") // 회원가입 페이지를 보여줌 
	public String userJoin() {
		return "user/userJoin";
	}
	
	@RequestMapping("/joinConfirm") // 회원가입 처리 
	public String confirmJoin(HttpServletRequest request, Model model, UDto udto, BindingResult result) {
		System.out.println("회원가입 유효성 검사 시작");
		String page = "main";
		
		UserValidator validator = new UserValidator();
		validator.validate(udto, result);
		if(result.hasErrors()) {
			model.addAttribute("error", "회원가입 오류 입니다. 정확한 정보를 입력해주세요.");
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
