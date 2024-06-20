package kr.soft.study.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.BDao;
import kr.soft.study.dto.BDto;
import kr.soft.study.user.command.Command;

public class BModifyActionCommand implements Command {

	@Override
	public void execute(Model model) {
		// 게시글 수정 된 내용으로 업데이트하기
		boolean result = false;
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int num = Integer.parseInt(request.getParameter("BOARD_NUM"));
		String board_pass = request.getParameter("BOARD_PASS");
		
		BDao boarddao=new BDao();
		BDto boarddata=new BDto();
		
		boolean usercheck=boarddao.isBoardWriter(num, board_pass); // 게시글 작성자 여부 확인 
		
		if(!usercheck) {
			model.addAttribute("error", "수정할 권한이 없습니다.");
			model.addAttribute("url", "../board/boardlist");
			
		}else {
			try{
				 boarddata.setBOARD_NUM(num);
				 boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
				 boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
				 
				 result = boarddao.boardModify(boarddata);
				 if(result==false){
			   		System.out.println("게시판 수정 실패");
			   		model.addAttribute("error", "게시판 수정 실패!");
			   		model.addAttribute("url", "../board/boardview");
			   		model.addAttribute("num", num);
			   	 }
			   	 System.out.println("게시판 수정 완료");
			   	 model.addAttribute("num", num);
			   	 System.out.println("수정 완료하고 num도 잘 담아짐" + num);
		   	 }catch(Exception ex){
		   			ex.printStackTrace();	 
			 }
		}
	}

}
