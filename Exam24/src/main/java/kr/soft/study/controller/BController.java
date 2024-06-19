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
		// Constant 클래스의 template변수는 public이라 외부에서 사용가능, static이라서 바로 사용가능
		// DAO 클래스 파일도 여러가지 있으므로, static으로 선언해서 동일한 template을 공유하겠다. 
		// BController.template과 Constant.template은 동일함
		// 왜 Constant에도 template을 분리시켜놓았는가? 
		// Dispatcher에서 무조건 컨트롤러로 오게 된다. 컨트롤러에서 JdbcTemplate 연결시킨다. 
		// Constant의 static template 변수에도 넣어준다. -> 다른 컨트롤러에서 매번 @Autowired 하는 것을 줄이고, Constant.template를 불러서 바로 사용하기 위해
		// service계층인 command 클래스에서 db연결이 필요할 때 앞으로 Constant.template를 사용하게 된다. 
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		System.out.println("게시판 리스트를 불러옵니다.");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("게시글 작성하기를 불러옵니다.");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("게시물 작성하기를 완료합니다.");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("게시글 상세보기를 불러옵니다.");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("게시글 수정하기를 불러옵니다.");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("답글 상세보기를 불러옵니다.");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("답글 달기를 불러옵니다.");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("게시글 삭제를 불러옵니다.");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}

}
