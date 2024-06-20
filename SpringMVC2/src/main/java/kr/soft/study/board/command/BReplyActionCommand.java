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
		// �ۼ��� ��� db�� insert �ϱ�
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
   		
   		result=boarddao.boardReply(boarddata); // �Խñ� �ѹ��� ��ȯ����
   		
   		if(result==0){
   			System.out.println("���� ����");
   			model.addAttribute("error", "���� ����!");
   			model.addAttribute("url", "../board/boardlist");
   		}
   		System.out.println("���� �Ϸ�");
   		
   		model.addAttribute("boarddata", boarddata);
   		model.addAttribute("num", result);

	}

}
