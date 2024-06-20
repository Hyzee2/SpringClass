package kr.soft.study.admin.command;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.dao.ADao;
import kr.soft.study.user.command.Command;

public class AListCommand implements Command {

	@Override
	public void execute(Model model) {
		// ������ ������� ȸ�� ����Ʈ�� �ҷ��´�. 
		ADao admindao=new ADao(); // db ����
		
		List<String> userList=new ArrayList<String>(); 
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		String id = (String)session.getAttribute("id");
		
		userList = admindao.adminList();
		
		model.addAttribute("userList", userList);

	}

}
