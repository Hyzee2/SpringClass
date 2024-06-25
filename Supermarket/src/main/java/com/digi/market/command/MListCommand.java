package com.digi.market.command;

import org.springframework.ui.Model;

import com.digi.market.dao.MDao;
import com.digi.market.dto.MDto;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

public class MListCommand implements Command {

	@Override
	public void execute(Model model) {
		// 장바구니 내역 데이터베이스에 담기 
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		MDao dao = new MDao();
		
		List<MDto> list = new ArrayList<MDto>();
		
		String[] itemNames = request.getParameterValues("name");
        String[] itemPrices = request.getParameterValues("price");
        String[] itemCounts = request.getParameterValues("count");
        
        if(Integer.parseInt(itemCounts[0])>0) {
        	MDto dto = new MDto();
        	dto.setName(itemNames[0]);
        	dto.setPrice(Integer.parseInt(itemPrices[0]));
        	dto.setCount(Integer.parseInt(itemCounts[0]));
        	list.add(dto);
        }
        
        if(Integer.parseInt(itemCounts[1])>0) {
        	MDto dto = new MDto();
        	dto.setName(itemNames[1]);
        	dto.setPrice(Integer.parseInt(itemPrices[1]));
        	dto.setCount(Integer.parseInt(itemCounts[1]));
        	list.add(dto);
        }
        
        if(Integer.parseInt(itemCounts[2])>0) {
        	MDto dto = new MDto();
        	dto.setName(itemNames[2]);
        	dto.setPrice(Integer.parseInt(itemPrices[2]));
        	dto.setCount(Integer.parseInt(itemCounts[2]));
        	list.add(dto);
        }
        
        boolean result = false;
        
        for(MDto dto : list) {
        	result = dao.insertItem(dto);
        }

	}

}
