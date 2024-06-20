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
				System.out.println("�Ϲ� ȸ�� �α��� �Ϸ�");
				session.setAttribute("id", id);
				session.setMaxInactiveInterval(60*30);
				System.out.println((String)session.getAttribute("id")+" ���ǿ� ������� Ȯ��!");
				
			}else if(usercheck == 0) {
				System.out.println("�����ڷ� �α��� �Ϸ�");
				session.setAttribute("id", id);
				session.setMaxInactiveInterval(60*30);
				model.addAttribute("admin", "admin");
				
			}else {
				System.out.println("�α��� ����");
				model.addAttribute("error", "�߸��� ���̵�� ��й�ȣ �Դϴ�.");
				model.addAttribute("url", "login");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
