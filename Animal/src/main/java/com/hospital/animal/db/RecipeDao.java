package com.hospital.animal.db;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hospital.animal.util.Constant;

public class RecipeDao {
	
	JdbcTemplate template;

	public RecipeDao() { // �����ڿ��� DB���� �ϵ���
		this.template = Constant.template;
	}

}
