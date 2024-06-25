package kr.soft.study.dao;

import java.util.ArrayList;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import kr.soft.study.dto.BaDto;
import kr.soft.study.util.Constant;

public class BaDao {

	JdbcTemplate template;

	public BaDao() { // �����ڿ��� DB���� �ϵ���
		this.template = Constant.template;
	}

	@Transactional
	public boolean basketAdd(BaDto basketdata) {
		// ��ٱ��� db�� ���� ��ǰ���� insert �ϱ�

		String sql = "select * from basket where id=? and item_name=?";

		int result = 0;

		try {
			BaDto basket = (BaDto) this.template.queryForObject(sql,
					new Object[] { basketdata.getId(), basketdata.getItem_name() },
					new BeanPropertyRowMapper<BaDto>(BaDto.class));
			if (basket != null) {
				sql = "update basket set item_total=item_total+? where id=? and item_name=?";
				result = this.template.update(sql,
						new Object[] { basketdata.getItem_total(), basketdata.getId(), basketdata.getItem_name() });

				return result > 0;
			}
		} catch (EmptyResultDataAccessException e) {

			sql = "insert into basket (id, item_name, item_price, item_total) values(?,?,?,?)";
			result = this.template.update(sql, new Object[] { basketdata.getId(), basketdata.getItem_name(),
					basketdata.getItem_price(), basketdata.getItem_total() });

			return result > 0;

		}
		return false;
	}

	public ArrayList<BaDto> basketList(String id) {
		// ��ٱ��� ���� select �ϱ�
		String basket_list_sql = "select * from basket where id = ?";

		ArrayList<BaDto> list = new ArrayList<BaDto>();

		return (ArrayList<BaDto>) this.template.query(basket_list_sql, new Object[] { id },
				new BeanPropertyRowMapper<BaDto>(BaDto.class));

	}

	public boolean basketModify(BaDto basketdata) {
		// DB�� ����� ��ٱ��� ���� update
		String sql = "update basket set item_total=? where id=? and item_name=?";

		int result = this.template.update(sql,
				new Object[] { basketdata.getItem_total(), basketdata.getId(), basketdata.getItem_name() });

		return result > 0;

	}

}
