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
				System.out.println("�Ϲ� ȸ�� �α��� �Ϸ�");
				session.setAttribute("id", id);
				session.setMaxInactiveInterval(60*30);
				System.out.println((String)session.getAttribute("id")+" ���ǿ� �������~");
			}else if(usercheck == 0) {
				System.out.println("�����ڷ� �α��� �Ϸ�");
				session.setAttribute("id", id);
				session.setMaxInactiveInterval(60*30);
				System.out.println((String)session.getAttribute("id")+" ���ǿ� �������~");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('������ �������� �Ѿ�ϴ�.');");
		   		out.println("location.href='../admin/admin_main';");
		   		out.println("</script>");
		   		out.close();
			}else {
				System.out.println("�α��� ����");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('�߸��� ���̵�� ��� �Դϴ�.');");
		   		out.println("location.href='login';");
		   		out.println("</script>");
		   		out.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
