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
		// 장바구니에 담은 제품들을 db에서 select하는 기능 
		BaDao basketdao=new BaDao(); // db 연결
		
		ArrayList<BaDto> basketlist=new ArrayList<BaDto>(); 
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		String id = (String)session.getAttribute("id"); // session에 담겨있던 id 꺼내오기 
		
		basketlist = basketdao.basketList(id);
		System.out.println("장바구니가 있는지?"+basketlist.toString());
		
		if(basketlist.isEmpty()){
	   		System.out.println("장바구니 내역 조회 없음");
	   		model.addAttribute("error", "장바구니 내역이 없습니다!");
	   		model.addAttribute("url", "../basket/item");
	   	 }else {
	   		System.out.println("여기 장바구니 내역 담겼다.");
	   		model.addAttribute("basketlist", basketlist);
	   	 }
	}

}
