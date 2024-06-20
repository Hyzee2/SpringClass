package kr.soft.study.basket.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.dao.BaDao;
import kr.soft.study.dto.BaDto;
import kr.soft.study.user.command.Command;

public class BaModifyCommand implements Command {

	@Override
	public void execute(Model model) {
		// ��ٱ��� ���� ���� db���� update �ϱ� 
		boolean result = false;
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
   		HttpSession session = (HttpSession)map.get("session");
   		String id = (String)session.getAttribute("id");
   		
   		String[] item_name = request.getParameterValues("item_name");
		String[] item_total = request.getParameterValues("item_total");
		 
		int resultCnt = 0;
		for(int i=0; i<item_name.length; i++, resultCnt++) {
			try{
				 BaDao basketdao=new BaDao();
				 BaDto basketdata=new BaDto();
				 
				 basketdata.setId(id);
				 basketdata.setItem_name(item_name[i]);
				 basketdata.setItem_total(item_total[i]);
				 
				 result = basketdao.basketModify(basketdata);
				 
				 System.out.println("i: "+i);
				 System.out.println(basketdata.toString());
				 
				 if(result==false){
			   		System.out.println("��ٱ��� ���� ����");
			   		model.addAttribute("error", "���� ����!");
			   		model.addAttribute("url", "../basket/basketList");
			   	 }
			   	 System.out.println("��ٱ��� ���� �Ϸ�");
			   	 
			   	 
		   	 }catch(Exception ex){
		   			ex.printStackTrace();	 
			 }
		 }
		 
		 //������ ����, �ٸ��� ����
		 if(item_name.length != resultCnt ) {
			System.out.println("��ٱ��� ���� ����");
			model.addAttribute("error", "���� ����!");
		   	model.addAttribute("url", "../basket/basketList");
		 }
   		

	}

}
