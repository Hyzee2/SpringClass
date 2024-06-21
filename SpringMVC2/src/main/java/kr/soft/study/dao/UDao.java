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
		// 회원가입 정보 insert

		String sql = "";

		int result = 0;

		try {
			sql = "Insert into user values (?,?,?,?,?,?,?,?)";

			result = template.update(sql, id, pw, mail, name, IDnum, birth, hobby, introduction);

		} catch (Exception ex) {
			System.out.println("회원 정보 등록 실패 : " + ex);
			return false;
		}
		return result > 0;
		// insert 구문을 실행하고, 삽입된 행의 수를 반환한다.
		// result가 0보다 크면, true를 반환
		// 이를 통해 insert 작업의 성공 여부를 boolean 형태로 알려줄 수 있다.
	}

	public int loginCheck(String id, String pw) throws SQLException {
		// 로그인한 id, pw 비교하기
		String sql = "";
		sql = "select id, pw from user where id=?";
		try {
			UDto dto = (UDto) template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<UDto>(UDto.class));
			// new Object[] { id }는 id 값을 포함하는 Object 배열을 생성한다. ? 자리 표시에 바인딩된다.
			// SQL 인젝션 공격을 방지한다. 
			if (dto == null) {
				return -1; // 비회원
			}

			String user_id = dto.getId();
			String user_pw = dto.getPw();

			if (id.equals("admin") && pw.equals("1234")) {
				return 0; // 관리자
			}
			if (user_id.equals(id) && user_pw.equals(pw)) {
				return 1; // 회원
			}
		} catch (EmptyResultDataAccessException e) {
			return -1; // 비회원
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return -1; // 비회원
	}

}
