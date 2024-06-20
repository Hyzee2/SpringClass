package kr.soft.study.admin.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.ADao;
import kr.soft.study.user.command.Command;

public class ADeleteCommand implements Command {

	@Override
	public void execute(Model model) {
		// 선택된 회원 삭제하기 
		ADao admindao=new ADao(); // db 연결
		
		boolean userDelete=false; 
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String userId = request.getParameter("userId");
		
		userDelete = admindao.adminDelete(userId);
		
		System.out.println("회원 삭제 여부: "+userDelete);

	}

}
