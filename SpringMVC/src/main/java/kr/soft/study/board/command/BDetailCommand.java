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
		// 게시판 상세보기 
		BDao dao = new BDao();
		BDto dto = new BDto();
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int num = Integer.parseInt(request.getParameter("num"));
		dao.setReadCountUpdate(num); // 조회수 증가 update
		dto = dao.getDetail(num); // 상세정보 가져오기 select
		
		if(dto == null) {
			System.out.println("상세보기 실패");
	   		model.addAttribute("error", "상세보기 실패");
		}
		
		System.out.println("상세보기 성공");
		model.addAttribute("boarddata", dto);
	}

}
