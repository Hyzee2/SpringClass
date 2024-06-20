package kr.soft.study.basket.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.dao.BaDao;
import kr.soft.study.dto.BaDto;
import kr.soft.study.user.command.Command;

public class BaAddCommand implements Command {

	@Override
	public void execute(Model model) {
		// ��ٱ��Ͽ� �߰��ϸ� db�� insert �ϴ� ��� 
		BaDao basketdao=new BaDao();
	   	BaDto basketdata=new BaDto();
	   	
   		boolean result=false;
   		
   		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
   		HttpSession session = (HttpSession)map.get("session");
		
   		try{
   			basketdata.setItem_name(request.getParameter("item_name"));
   			basketdata.setItem_price(request.getParameter("item_price"));
   			basketdata.setItem_total(request.getParameter("item_total"));
   			
   			session = request.getSession();
   			basketdata.setId((String)session.getAttribute("id"));
	   		
	   		result=basketdao.basketAdd(basketdata);
	   		
	   		if(result==false){
	   			System.out.println("��ٱ��� ��� ����");
	   			model.addAttribute("error", "��ٱ��� ��� ����!");
	   			model.addAttribute("url", "../basket/item");
	   		}
	   		System.out.println("��ٱ��� ��� �Ϸ�");
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
  		
	}

}
