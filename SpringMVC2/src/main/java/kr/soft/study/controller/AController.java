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
	
	@RequestMapping("/admin_main") // ������ ���� ������ �����ֱ�
	public String main(HttpSession session, Model model) {
		System.out.println("ȸ�� ����� �ҷ��ɴϴ�.");
		model.addAttribute("session", session);
		command = new AListCommand();
		command.execute(model);
		return "admin/adminList";
	}
	
	@RequestMapping("/adminDetail") // ���õ� ȸ�� �󼼺��� 
	public String adminDetail(HttpServletRequest request, Model model) {
		System.out.println("ȸ�� ���� �󼼺���");
		model.addAttribute("request", request);
		command = new ADetailCommand();
		command.execute(model);
		return "admin/adminDetail";
	}
	
	@RequestMapping("/adminDelete") // ���õ� ȸ�� �����ϱ�
	public String adminDelete(HttpServletRequest request, Model model) {
		System.out.println("ȸ�� �����ϱ�");
		model.addAttribute("request", request);
		command = new ADeleteCommand();
		command.execute(model);
		return "redirect:admin_main";
	}
}
