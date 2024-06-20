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
		System.out.println("게시판 리스트를 불러옵니다.");
		model.addAttribute("request", request);
		command = new BListCommand();
		command.execute(model);
		
		return "board/boardList";
	}
	
	@RequestMapping("/boardDetail")
	public String boardDetail(HttpServletRequest request, Model model) {
		System.out.println("게시판 상세보기를 불러옵니다.");
		model.addAttribute("request", request);
		command = new BDetailCommand();
		command.execute(model);
		
		return "board/boardview";
	}
	
	@RequestMapping("/boardModify")
	public String boardModify(HttpServletRequest request, Model model) {
		System.out.println("게시판 수정하기를 불러옵니다.");
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "board/boardmodify";
	}
	
	@RequestMapping("/boardModifyAction")
	public String boardModifyAction(HttpServletRequest request, Model model) {
		System.out.println("게시판 수정 업데이트 완료");
		model.addAttribute("request", request);
		command = new BModifyActionCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		
		// 에러 메시지가 있는 경우, 수정 실패로 간주하고 메시지와 함께 게시판 상세보기 화면으로 리다이렉트
		if(map.containsKey("error")) {
			model.addAttribute("error", map.get("error"));
			model.addAttribute("url", map.get("url"));
			return "message";
		}
		return "redirect:boardlist";
	}
	
	@RequestMapping("/boardWrite") // 게시글 쓰기 화면으로 이동 
	public String boardWrite(Model model) {
		return "board/boardwrite";
	}	
	
	@RequestMapping("/boardAddAction") // 작성한 게시글 db에 insert 
	public String boardAdd(HttpServletRequest request, Model model) {
		System.out.println("작성한 게시글을 저장합니다.");
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
	
	@RequestMapping("/boardDelete") // 게시글 삭제 페이지로 이동하기 
	public String boardDelete(HttpServletRequest request, Model model) {
		System.out.println("게시글 삭제 페이지로 이동합니다.");
		model.addAttribute("request", request);
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("request");
		String num = req.getParameter("num");
		
		model.addAttribute("num", num);
		
		return "board/boarddelete";
	}
	
	@RequestMapping("/boardDeleteAction") // 게시글 삭제 
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
	
	@RequestMapping("/boardReplyView") // 게시글에 답글 작성 페이지로 이동 
	public String boardReplyView(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		return "board/boardreply";
	}
	
	@RequestMapping("/boardReplyAction") // 작성한 답글 등록하기 
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
