package kr.soft.study.admin.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.ADao;
import kr.soft.study.user.command.Command;

public class ADeleteCommand implements Command {

	@Override
	public void execute(Model model) {
		// ���õ� ȸ�� �����ϱ� 
		ADao admindao=new ADao(); // db ����
		
		boolean userDelete=false; 
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String userId = request.getParameter("userId");
		
		userDelete = admindao.adminDelete(userId);
		
		System.out.println("ȸ�� ���� ����: "+userDelete);

	}

}
