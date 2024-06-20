package kr.soft.study.admin.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.ADao;
import kr.soft.study.dto.UDto;
import kr.soft.study.user.command.Command;

public class ADetailCommand implements Command {

	@Override
	public void execute(Model model) {
		// 넘겨받은 회원 id로 선택된 회원 상세보여주기 
		ADao admindao=new ADao(); // db 연결
		
		UDto userDetail=new UDto(); 
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String userId = request.getParameter("userId");
		
		userDetail = admindao.adminDetail(userId);
		
		model.addAttribute("userDetail", userDetail);

	}

}
