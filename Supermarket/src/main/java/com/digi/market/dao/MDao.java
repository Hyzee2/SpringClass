package com.digi.market.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.digi.market.dto.MDto;

public class MDao {
	
	@Autowired
	private JdbcTemplate template;

	public boolean insertItem(MDto dto) {
		// 장바구니 내역 insert 
		String sql = "insert into (name, price, count) values (?,?,?)";
		int result = this.template.update(sql, new Object[] {dto.getName(), dto.getPrice(), dto.getCount()});
		return result > 0;
	}

}
