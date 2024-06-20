package kr.soft.study.user.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.dao.UDao;

public class UJoinCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession(); // HttpSession ��ü �������� 
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String IDnum = request.getParameter("IDnum");
		String birth = request.getParameter("IDnum").substring(0,6);
		String[] hobbies = request.getParameterValues("hobby");
		String hobby = String.join(", ", hobbies); 
		String introduction = request.getParameter("introduction");
		
		UDao dao = new UDao();
		boolean result = false;
		
		result = dao.join(id, pw, mail, name, IDnum, birth, hobby, introduction);
		
		if(result) {
			System.out.println("insert ����");
			session.setAttribute("id", id); // session�� id ����ֱ� 
			session.setMaxInactiveInterval(60*30);
			System.out.println((String)session.getAttribute("id")+" ���ǿ� �������~");
		}else {
			System.out.println("insert ����");
		}
		
	}

}
