package kr.soft.study.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import kr.soft.study.dto.UDto;
import kr.soft.study.util.Constant;

public class UDao {

	JdbcTemplate template;

	public UDao() {
		this.template = Constant.template;
	}

	public boolean join(final String id, final String pw, final String mail, final String name, final String IDnum,
			final String birth, final String hobby, final String introduction) {
		// ȸ������ ���� insert

		String sql = "";

		int result = 0;

		try {
			sql = "Insert into user values (?,?,?,?,?,?,?,?)";

			result = template.update(sql, id, pw, mail, name, IDnum, birth, hobby, introduction);

		} catch (Exception ex) {
			System.out.println("ȸ�� ���� ��� ���� : " + ex);
			return false;
		}
		return result > 0;
		// insert ������ �����ϰ�, ���Ե� ���� ���� ��ȯ�Ѵ�.
		// result�� 0���� ũ��, true�� ��ȯ
		// �̸� ���� insert �۾��� ���� ���θ� boolean ���·� �˷��� �� �ִ�.
	}

	public int loginCheck(String id, String pw) throws SQLException {
		// �α����� id, pw ���ϱ�
		String sql = "";
		sql = "select id, pw from user where id=?";
		try {
			UDto dto = (UDto) template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<UDto>(UDto.class));
			// new Object[] { id }�� id ���� �����ϴ� Object �迭�� �����Ѵ�. ? �ڸ� ǥ�ÿ� ���ε��ȴ�.
			// SQL ������ ������ �����Ѵ�. 
			if (dto == null) {
				return -1; // ��ȸ��
			}

			String user_id = dto.getId();
			String user_pw = dto.getPw();

			if (id.equals("admin") && pw.equals("1234")) {
				return 0; // ������
			}
			if (user_id.equals(id) && user_pw.equals(pw)) {
				return 1; // ȸ��
			}
		} catch (EmptyResultDataAccessException e) {
			return -1; // ��ȸ��
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return -1; // ��ȸ��
	}

}
