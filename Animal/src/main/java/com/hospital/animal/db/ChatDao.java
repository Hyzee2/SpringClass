package com.hospital.animal.db;

import org.springframework.jdbc.core.JdbcTemplate;
import com.hospital.animal.util.Constant;

public class ChatDao {
	
	JdbcTemplate template;

	public ChatDao() { // �����ڿ��� DB���� �ϵ���
		this.template = Constant.template;
	}

}