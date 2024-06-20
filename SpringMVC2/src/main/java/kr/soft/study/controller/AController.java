package kr.soft.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.soft.study.admin.command.ADeleteCommand;
import kr.soft.study.admin.command.ADetailCommand;
import kr.soft.study.admin.command.AListCommand;
import kr.soft.study.user.command.Command;

@Controller
@RequestMapping("/admin")
public class AController {
	
	Command command = null;
	
	@RequestMapping("/admin_main") // 관리자 메인 페이지 보여주기
	public String main(HttpSession session, Model model) {
		System.out.println("회원 목록을 불러옵니다.");
		model.addAttribute("session", session);
		command = new AListCommand();
		command.execute(model);
		return "admin/adminList";
	}
	
	@RequestMapping("/adminDetail") // 선택된 회원 상세보기 
	public String adminDetail(HttpServletRequest request, Model model) {
		System.out.println("회원 정보 상세보기");
		model.addAttribute("request", request);
		command = new ADetailCommand();
		command.execute(model);
		return "admin/adminDetail";
	}
	
	@RequestMapping("/adminDelete") // 선택된 회원 삭제하기
	public String adminDelete(HttpServletRequest request, Model model) {
		System.out.println("회원 삭제하기");
		model.addAttribute("request", request);
		command = new ADeleteCommand();
		command.execute(model);
		return "redirect:admin_main";
	}
}
