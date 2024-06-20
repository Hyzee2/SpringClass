package kr.soft.study.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.BDao;
import kr.soft.study.dto.BDto;
import kr.soft.study.user.command.Command;

public class BReplyCommand implements Command {

	@Override
	public void execute(Model model) {
		// 선택 게시글에 답글 작성하는 페이지
		BDao boarddao=new BDao();
   		BDto boarddata=new BDto();
   		
   		Map<String, Object> map = model.asMap();
   		HttpServletRequest request = (HttpServletRequest)map.get("request");
   		
   		int num=Integer.parseInt(request.getParameter("num"));
   		
   		boarddata=boarddao.getDetail(num);
   		
   		if(boarddata==null){
   			System.out.println("답장 페이지 이동 실패");
   		}
   		System.out.println("답장 페이지 이동 완료");
   		
   		model.addAttribute("boarddata", boarddata);
   		
	}

}
