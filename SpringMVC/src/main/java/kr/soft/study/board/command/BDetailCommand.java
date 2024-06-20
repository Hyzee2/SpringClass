package kr.soft.study.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.BDao;
import kr.soft.study.dto.BDto;
import kr.soft.study.user.command.Command;

public class BDetailCommand implements Command {

	@Override
	public void execute(Model model) {
		// �Խ��� �󼼺��� 
		BDao dao = new BDao();
		BDto dto = new BDto();
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int num = Integer.parseInt(request.getParameter("num"));
		dao.setReadCountUpdate(num); // ��ȸ�� ���� update
		dto = dao.getDetail(num); // ������ �������� select
		
		if(dto == null) {
			System.out.println("�󼼺��� ����");
	   		model.addAttribute("error", "�󼼺��� ����");
		}
		
		System.out.println("�󼼺��� ����");
		model.addAttribute("boarddata", dto);
	}

}
