package kr.soft.study.user.command;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.dao.UDao;

public class ULoginCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UDao dao = new UDao();
		
		try {
			int usercheck = dao.loginCheck(id, pw);
			
			if(usercheck == 1) {
				System.out.println("일반 회원 로그인 완료");
				session.setAttribute("id", id);
				session.setMaxInactiveInterval(60*30);
				System.out.println((String)session.getAttribute("id")+" 세션에 담겨졌다~");
			}else if(usercheck == 0) {
				System.out.println("관리자로 로그인 완료");
				session.setAttribute("id", id);
				session.setMaxInactiveInterval(60*30);
				System.out.println((String)session.getAttribute("id")+" 세션에 담겨졌다~");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('관리자 페이지로 넘어갑니다.');");
		   		out.println("location.href='../admin/admin_main';");
		   		out.println("</script>");
		   		out.close();
			}else {
				System.out.println("로그인 실패");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('잘못된 아이디와 비번 입니다.');");
		   		out.println("location.href='login';");
		   		out.println("</script>");
		   		out.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
