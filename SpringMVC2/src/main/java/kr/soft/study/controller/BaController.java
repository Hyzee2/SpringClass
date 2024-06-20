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
	
	@RequestMapping("/item") // 제품 리스트 보여주기 
	public String item() {
		return "basket/item";
	}
	
	@RequestMapping("/basketAdd") // 장바구니에 상품 담기
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
	
	@RequestMapping("/basketList") // 장바구니 내역 보여주기 
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
	
	@RequestMapping("/basketModify") // 장바구니 화면에서 수량 수정하기 
	public String basketModify(HttpServletRequest request, HttpSession session, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("session", session);
		command = new BaModifyCommand();
		command.execute(model);
		return "redirect:../user/main";
	}

}
