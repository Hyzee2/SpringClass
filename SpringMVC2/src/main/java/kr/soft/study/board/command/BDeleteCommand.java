package kr.soft.study.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.BDao;
import kr.soft.study.user.command.Command;

public class BDeleteCommand implements Command {

	@Override
	public void execute(Model model) {
		// ���õ� �Խñ� db���� delete �ϱ�
		BDao boarddao = new BDao();
		
		boolean result = false;
		boolean usercheck = false;
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int num = Integer.parseInt(request.getParameter("num"));
		usercheck = boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));

		if (usercheck == false) {
			model.addAttribute("error", "������ ������ �����ϴ�.");
			model.addAttribute("url", "../board/boardlist");
		}

		result = boarddao.boardDelete(num);
		if (result == false) {
			System.out.println("�Խñ� ���� ����");
			model.addAttribute("error", "�Խñ� ���� ����!");
			model.addAttribute("url", "../board/boardlist");
		}

		System.out.println("�Խñ� ���� ����");
		model.addAttribute("num", num);

	}

}
