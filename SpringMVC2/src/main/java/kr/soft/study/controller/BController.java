package kr.soft.study.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.soft.study.board.command.BDeleteCommand;
import kr.soft.study.board.command.BDetailCommand;
import kr.soft.study.board.command.BListCommand;
import kr.soft.study.board.command.BModifyActionCommand;
import kr.soft.study.board.command.BModifyCommand;
import kr.soft.study.board.command.BReplyActionCommand;
import kr.soft.study.board.command.BReplyCommand;
import kr.soft.study.board.command.BWriteCommand;
import kr.soft.study.user.command.Command;

@Controller
@RequestMapping("board")
public class BController {
	
	Command command = null;
	
	@RequestMapping("/boardlist")
	public String boardList(HttpServletRequest request, Model model) {
		System.out.println("�Խ��� ����Ʈ�� �ҷ��ɴϴ�.");
		model.addAttribute("request", request);
		command = new BListCommand();
		command.execute(model);
		
		return "board/boardList";
	}
	
	@RequestMapping("/boardDetail")
	public String boardDetail(HttpServletRequest request, Model model) {
		System.out.println("�Խ��� �󼼺��⸦ �ҷ��ɴϴ�.");
		model.addAttribute("request", request);
		command = new BDetailCommand();
		command.execute(model);
		
		return "board/boardview";
	}
	
	@RequestMapping("/boardModify")
	public String boardModify(HttpServletRequest request, Model model) {
		System.out.println("�Խ��� �����ϱ⸦ �ҷ��ɴϴ�.");
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "board/boardmodify";
	}
	
	@RequestMapping("/boardModifyAction")
	public String boardModifyAction(HttpServletRequest request, Model model) {
		System.out.println("�Խ��� ���� ������Ʈ �Ϸ�");
		model.addAttribute("request", request);
		command = new BModifyActionCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		
		// ���� �޽����� �ִ� ���, ���� ���з� �����ϰ� �޽����� �Բ� �Խ��� �󼼺��� ȭ������ �����̷�Ʈ
		if(map.containsKey("error")) {
			model.addAttribute("error", map.get("error"));
			model.addAttribute("url", map.get("url"));
			return "message";
		}
		return "redirect:boardlist";
	}
	
	@RequestMapping("/boardWrite") // �Խñ� ���� ȭ������ �̵� 
	public String boardWrite(Model model) {
		return "board/boardwrite";
	}	
	
	@RequestMapping("/boardAddAction") // �ۼ��� �Խñ� db�� insert 
	public String boardAdd(HttpServletRequest request, Model model) {
		System.out.println("�ۼ��� �Խñ��� �����մϴ�.");
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		
		if(map.containsKey("error")) {
			model.addAttribute("error", map.get("error"));
			model.addAttribute("url", map.get("url"));
			return "message";
		}
		
		return "redirect:boardlist";
	}
	
	@RequestMapping("/boardDelete") // �Խñ� ���� �������� �̵��ϱ� 
	public String boardDelete(HttpServletRequest request, Model model) {
		System.out.println("�Խñ� ���� �������� �̵��մϴ�.");
		model.addAttribute("request", request);
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("request");
		String num = req.getParameter("num");
		
		model.addAttribute("num", num);
		
		return "board/boarddelete";
	}
	
	@RequestMapping("/boardDeleteAction") // �Խñ� ���� 
	public String boardDeleteAction(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		
		if(map.containsKey("error")) {
			model.addAttribute("error", map.get("error"));
			model.addAttribute("url", map.get("url"));
			return "message";
		}
		
		return "redirect:boardlist";
	}
	
	@RequestMapping("/boardReplyView") // �Խñۿ� ��� �ۼ� �������� �̵� 
	public String boardReplyView(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		return "board/boardreply";
	}
	
	@RequestMapping("/boardReplyAction") // �ۼ��� ��� ����ϱ� 
	public String boardReplyAction(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BReplyActionCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		
		if(map.containsKey("error")) {
			model.addAttribute("error", map.get("error"));
			model.addAttribute("url", map.get("url"));
			return "message";
		}
		
		return "redirect:boardlist";
	}
	

}
