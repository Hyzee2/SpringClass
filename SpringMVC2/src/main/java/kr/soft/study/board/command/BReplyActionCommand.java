package kr.soft.study.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.BDao;
import kr.soft.study.dto.BDto;
import kr.soft.study.user.command.Command;

public class BReplyActionCommand implements Command {

	@Override
	public void execute(Model model) {
		// 작성한 답글 db에 insert 하기
		BDao boarddao=new BDao();
   		BDto boarddata=new BDto();
   		int result=0;	
   		
   		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		boarddata.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
   		boarddata.setBOARD_NAME(request.getParameter("BOARD_NAME"));
   		boarddata.setBOARD_PASS(request.getParameter("BOARD_PASS"));
   		boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
   		boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
   		boarddata.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
   		boarddata.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
   		boarddata.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));
   		
   		result=boarddao.boardReply(boarddata); // 게시글 넘버를 반환받음
   		
   		if(result==0){
   			System.out.println("답장 실패");
   			model.addAttribute("error", "답장 실패!");
   			model.addAttribute("url", "../board/boardlist");
   		}
   		System.out.println("답장 완료");
   		
   		model.addAttribute("boarddata", boarddata);
   		model.addAttribute("num", result);

	}

}
