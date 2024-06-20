package kr.soft.study.user.command;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import kr.soft.study.dao.UDao;

public class ULoginCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = (HttpSession)map.get("session");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UDao dao = new UDao();
		
		try {
			int usercheck = dao.loginCheck(id, pw);
			
			if(usercheck == 1) {
				System.out.println("일반 회원 로그인 완료");
				session.setAttribute("id", id);
				session.setMaxInactiveInterval(60*30);
				System.out.println((String)session.getAttribute("id")+" 세션에 담겨진거 확인!");
				
			}else if(usercheck == 0) {
				System.out.println("관리자로 로그인 완료");
				session.setAttribute("id", id);
				session.setMaxInactiveInterval(60*30);
				model.addAttribute("admin", "admin");
				
			}else {
				System.out.println("로그인 실패");
				model.addAttribute("error", "잘못된 아이디와 비밀번호 입니다.");
				model.addAttribute("url", "login");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
