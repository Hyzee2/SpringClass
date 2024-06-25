package kr.soft.study.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import kr.soft.study.dao.BoardDao;
import kr.soft.study.util.Constant;

public class BModifyCommand implements BCommand {
	
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
//		
//		BDao dao = new BDao();
//		dao.modify(bId, bName, bTitle, bContent);
		
		
		Constant.dao.modify(bName, bTitle, bContent, bId);

	}

}
