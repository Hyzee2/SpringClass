package com.hospital.animal.db;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hospital.animal.util.Constant;

public class ReservDao {
	
	JdbcTemplate template;

	public ReservDao() { // �����ڿ��� DB���� �ϵ���
		this.template = Constant.template;
	}

}
