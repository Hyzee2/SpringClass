package com.hospital.animal.db;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hospital.animal.util.Constant;

public class NoticeDao {
	
	JdbcTemplate template;

	public NoticeDao() { // �����ڿ��� DB���� �ϵ���
		this.template = Constant.template;
	}

}
