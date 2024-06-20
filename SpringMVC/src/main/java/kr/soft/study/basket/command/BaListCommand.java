package kr.soft.study.basket.command;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.dao.BaDao;
import kr.soft.study.dto.BaDto;
import kr.soft.study.user.command.Command;

public class BaListCommand implements Command {

	@Override
	public void execute(Model model) {
		// ��ٱ��Ͽ� ���� ��ǰ���� db���� select�ϴ� ��� 
		BaDao basketdao=new BaDao(); // db ����
		
		ArrayList<BaDto> basketlist=new ArrayList<BaDto>(); 
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		String id = (String)session.getAttribute("id"); // session�� ����ִ� id �������� 
		
		basketlist = basketdao.basketList(id);
		System.out.println("��ٱ��ϰ� �ִ���?"+basketlist.toString());
		
		if(basketlist.isEmpty()){
	   		System.out.println("��ٱ��� ���� ��ȸ ����");
	   		model.addAttribute("error", "��ٱ��� ������ �����ϴ�!");
	   		model.addAttribute("url", "../basket/item");
	   	 }else {
	   		System.out.println("���� ��ٱ��� ���� ����.");
	   		model.addAttribute("basketlist", basketlist);
	   	 }
	}

}
