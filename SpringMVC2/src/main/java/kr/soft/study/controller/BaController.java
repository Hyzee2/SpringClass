package kr.soft.study.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.soft.study.basket.command.BaAddCommand;
import kr.soft.study.basket.command.BaListCommand;
import kr.soft.study.basket.command.BaModifyCommand;
import kr.soft.study.user.command.Command;

@Controller
@RequestMapping("/basket")
public class BaController {
	
	Command command = null;
	
	@RequestMapping("/item") // ��ǰ ����Ʈ �����ֱ� 
	public String item() {
		return "basket/item";
	}
	
	@RequestMapping("/basketAdd") // ��ٱ��Ͽ� ��ǰ ���
	public String basketAdd(HttpServletRequest request, HttpSession session, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("session", session);
		command = new BaAddCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		
		if(map.containsKey("error")) {
			model.addAttribute("error", map.get("error"));
			model.addAttribute("url", map.get("url"));
			return "message";
		}
		
		return "redirect:basketList";
	}
	
	@RequestMapping("/basketList") // ��ٱ��� ���� �����ֱ� 
	public String basketList(HttpSession session, Model model) {
		model.addAttribute("session", session);
		command = new BaListCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		
		if(map.containsKey("error")) {
			model.addAttribute("error", map.get("error"));
			model.addAttribute("url", map.get("url"));
			return "message";
		}
		
		return "basket/basket";
	}
	
	@RequestMapping("/basketModify") // ��ٱ��� ȭ�鿡�� ���� �����ϱ� 
	public String basketModify(HttpServletRequest request, HttpSession session, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("session", session);
		command = new BaModifyCommand();
		command.execute(model);
		return "redirect:../user/main";
	}

}
