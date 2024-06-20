package kr.soft.study.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.BDao;
import kr.soft.study.dto.BDto;
import kr.soft.study.user.command.Command;

public class BModifyCommand implements Command {

	@Override
	public void execute(Model model) {
		// 게시판 수정하기 화면 보여주기 
		BDao dao = new BDao();
		BDto dto = new BDto();
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		System.out.println("이건 게시글 넘버: "+request.getParameter("num"));
		int num = Integer.parseInt(request.getParameter("num"));
		dto = dao.getDetail(num);
	   	
	   	if(dto==null){
	   		System.out.println("수정화면보기 실패");
	   		model.addAttribute("error", "게시판 수정화면보기 실패");
	   	}
	   	System.out.println("수정화면보기 성공");
	   	model.addAttribute("boarddata", dto);
	   	model.addAttribute("num", num);

	}

}
