package kr.soft.study.command;

import java.util.Map;

import javax.lang.model.element.ModuleElement;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import kr.soft.study.dao.BoardDao;
import kr.soft.study.dto.BDto;
import kr.soft.study.util.Constant;

public class BReplyViewCommand implements BCommand {
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bId = request.getParameter("bId");
//		
//		BDao dao = new BDao();
//		BDto dto = dao.reply_view(bId);
//		
//		model.addAttribute("reply_view", dto);
		
		model.addAttribute("reply_view", Constant.dao.reply_view(bId));
		

	}

}
