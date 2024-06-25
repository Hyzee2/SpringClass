package com.hospital.animal.db;

import org.springframework.jdbc.core.JdbcTemplate;
import com.hospital.animal.util.Constant;

public class ChatDao {
	
	JdbcTemplate template;

	public ChatDao() { // 생성자에서 DB연결 하도록
		this.template = Constant.template;
	}

}
