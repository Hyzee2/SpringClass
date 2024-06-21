package kr.soft.study.dao;

import java.util.*;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import kr.soft.study.dto.UDto;
import kr.soft.study.util.Constant;

public class ADao {
	
	JdbcTemplate template;

	public ADao() { // 생성자에서 DB연결 하도록
		this.template = Constant.template;
	}

	public List<String> adminList() {
		// DB에서 user 목록 select 하는 기능
		String sql = "select id from user";

		return this.template.queryForList(sql, String.class);
		
	}

	public UDto adminDetail(String userId) {
		
		String sql = "select id, mail, name, IDnum, birth, hobby, introduction from user where id = ?";
		
		UDto user = this.template.queryForObject(sql, new Object[] {userId}, new BeanPropertyRowMapper<UDto>(UDto.class));
		
		return user;
		
	}

	public boolean adminDelete(String userId) {
		// DB에서 선택된 회원 delete 하는 기능 
		String sql="delete from user where id=?";
		String sql2="delete from basket where id=?";
		
		int result1 = this.template.update(sql, new Object[] {userId});
		int result2 = this.template.update(sql2, new Object[] {userId});
		
		return result1 > 0 && result2 > 0;
		
	}

}
