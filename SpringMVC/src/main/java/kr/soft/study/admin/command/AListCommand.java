package kr.soft.study.admin.command;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.dao.ADao;
import kr.soft.study.user.command.Command;

public class AListCommand implements Command {

	@Override
	public void execute(Model model) {
		// 관리자 기능으로 회원 리스트를 불러온다. 
		ADao admindao=new ADao(); // db 연결
		
		List<String> userList=new ArrayList<String>(); 
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		String id = (String)session.getAttribute("id");
		
		userList = admindao.adminList();
		
		model.addAttribute("userList", userList);

	}

}
