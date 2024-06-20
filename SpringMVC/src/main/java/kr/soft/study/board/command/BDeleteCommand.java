package kr.soft.study.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.BDao;
import kr.soft.study.user.command.Command;

public class BDeleteCommand implements Command {

	@Override
	public void execute(Model model) {
		// 선택된 게시글 db에서 delete 하기
		BDao boarddao = new BDao();
		
		boolean result = false;
		boolean usercheck = false;
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int num = Integer.parseInt(request.getParameter("num"));
		usercheck = boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));

		if (usercheck == false) {
			model.addAttribute("error", "삭제할 권한이 없습니다.");
			model.addAttribute("url", "../board/boardlist");
		}

		result = boarddao.boardDelete(num);
		if (result == false) {
			System.out.println("게시글 삭제 실패");
			model.addAttribute("error", "게시글 삭제 실패!");
			model.addAttribute("url", "../board/boardlist");
		}

		System.out.println("게시글 삭제 성공");
		model.addAttribute("num", num);

	}

}
