package kr.soft.study.board.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.BDao;
import kr.soft.study.dto.BDto;
import kr.soft.study.user.command.Command;

public class BListCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		BDao dao = new BDao();
		
		int page = 1; // 페이지 초기화 과정 
		int limit = 10;
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount = dao.getListCount();
		
		ArrayList<BDto> dtos = dao.getBoardList(page, limit);
		
		// 페이지 처리 시작 
   		int maxpage=(int)((double)listcount/limit+0.95); 
   		
   		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		
   		int endpage = maxpage;
   		
   		if (endpage>startpage+10-1) endpage=startpage+10-1;
   		// 페이지 처리 끝 
   		
   		model.addAttribute("page", page);
   		model.addAttribute("maxpage", maxpage);
   		model.addAttribute("startpage", startpage);
   		model.addAttribute("endpage", endpage);
   		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", dtos);
	}

}
