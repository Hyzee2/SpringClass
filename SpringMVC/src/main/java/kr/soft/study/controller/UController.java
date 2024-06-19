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
	
	@RequestMapping("/login") // 로그인 페이지를 보여줌 
	public String confirmLogin() {
		return "user/loginForm";
	}
	
	@RequestMapping("/loginConfirm") // 로그인 처리 
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, UDto udto) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		System.out.println("여기까지 성공!");
		command = new ULoginCommand();
		command.execute(model);
		return "redirect:main";
	}
	
	@RequestMapping("/logout") // 로그아웃 처리 
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃 완료");
		return "redirect:main";
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
