package kr.soft.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.soft.study.command.BCommand;
import kr.soft.study.command.BContentCommand;
import kr.soft.study.command.BDeleteCommand;
import kr.soft.study.command.BListCommand;
import kr.soft.study.command.BModifyCommand;
import kr.soft.study.command.BReplyCommand;
import kr.soft.study.command.BReplyViewCommand;
import kr.soft.study.command.BWriteCommand;
import kr.soft.study.util.*;

@Controller
public class BController {
	
	BCommand command = null;
	
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template; 
		// Constant Ŭ������ template������ public�̶� �ܺο��� ��밡��, static�̶� �ٷ� ��밡��
		// DAO Ŭ���� ���ϵ� �������� �����Ƿ�, static���� �����ؼ� ������ template�� �����ϰڴ�. 
		// BController.template�� Constant.template�� ������
		// �� Constant���� template�� �и����ѳ��Ҵ°�? 
		// Dispatcher���� ������ ��Ʈ�ѷ��� ���� �ȴ�. ��Ʈ�ѷ����� JdbcTemplate �����Ų��. 
		// Constant�� static template �������� �־��ش�. -> �ٸ� ��Ʈ�ѷ����� �Ź� @Autowired �ϴ� ���� ���̰�, Constant.template�� �ҷ��� �ٷ� ����ϱ� ����
		// service������ command Ŭ�������� db������ �ʿ��� �� ������ Constant.template�� ����ϰ� �ȴ�. 
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		System.out.println("�Խ��� ����Ʈ�� �ҷ��ɴϴ�.");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("�Խñ� �ۼ��ϱ⸦ �ҷ��ɴϴ�.");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("�Խù� �ۼ��ϱ⸦ �Ϸ��մϴ�.");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("�Խñ� �󼼺��⸦ �ҷ��ɴϴ�.");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("�Խñ� �����ϱ⸦ �ҷ��ɴϴ�.");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("��� �󼼺��⸦ �ҷ��ɴϴ�.");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("��� �ޱ⸦ �ҷ��ɴϴ�.");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("�Խñ� ������ �ҷ��ɴϴ�.");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}

}
