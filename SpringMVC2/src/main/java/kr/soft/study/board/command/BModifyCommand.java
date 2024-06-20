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
		// �Խ��� �����ϱ� ȭ�� �����ֱ� 
		BDao dao = new BDao();
		BDto dto = new BDto();
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		System.out.println("�̰� �Խñ� �ѹ�: "+request.getParameter("num"));
		int num = Integer.parseInt(request.getParameter("num"));
		dto = dao.getDetail(num);
	   	
	   	if(dto==null){
	   		System.out.println("����ȭ�麸�� ����");
	   		model.addAttribute("error", "�Խ��� ����ȭ�麸�� ����");
	   	}
	   	System.out.println("����ȭ�麸�� ����");
	   	model.addAttribute("boarddata", dto);
	   	model.addAttribute("num", num);

	}

}
