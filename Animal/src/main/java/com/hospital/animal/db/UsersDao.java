package com.hospital.animal.db;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hospital.animal.util.Constant;

public class UsersDao {
	
	JdbcTemplate template;

	public UsersDao() { // �����ڿ��� DB���� �ϵ���
		this.template = Constant.template;
	}

}
