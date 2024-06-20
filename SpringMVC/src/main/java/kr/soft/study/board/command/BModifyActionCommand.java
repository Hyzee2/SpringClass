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
		// �Խñ� ���� �� �������� ������Ʈ�ϱ�
		boolean result = false;
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int num = Integer.parseInt(request.getParameter("BOARD_NUM"));
		String board_pass = request.getParameter("BOARD_PASS");
		
		BDao boarddao=new BDao();
		BDto boarddata=new BDto();
		
		boolean usercheck=boarddao.isBoardWriter(num, board_pass); // �Խñ� �ۼ��� ���� Ȯ�� 
		
		if(!usercheck) {
			model.addAttribute("error", "������ ������ �����ϴ�.");
			model.addAttribute("url", "../board/boardlist");
			
		}else {
			try{
				 boarddata.setBOARD_NUM(num);
				 boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
				 boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
				 
				 result = boarddao.boardModify(boarddata);
				 if(result==false){
			   		System.out.println("�Խ��� ���� ����");
			   		model.addAttribute("error", "�Խ��� ���� ����!");
			   		model.addAttribute("url", "../board/boardview");
			   		model.addAttribute("num", num);
			   	 }
			   	 System.out.println("�Խ��� ���� �Ϸ�");
			   	 model.addAttribute("num", num);
			   	 System.out.println("���� �Ϸ��ϰ� num�� �� �����" + num);
		   	 }catch(Exception ex){
		   			ex.printStackTrace();	 
			 }
		}
	}

}
