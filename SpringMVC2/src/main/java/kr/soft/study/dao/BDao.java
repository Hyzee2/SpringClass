package kr.soft.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import kr.soft.study.dto.BDto;
import kr.soft.study.util.Constant;

public class BDao {
	
	JdbcTemplate template;
	
	public BDao() { // �����ڿ��� DB���� �ϵ��� 
		this.template = Constant.template;
	}

	public ArrayList<BDto> getBoardList(int page, int limit) {
		// �Խ��� ����Ʈ �ҷ����� 
		String sql = "select * from " + "(select row_number() over() rnum,BOARD_NUM,BOARD_NAME,BOARD_SUBJECT,"
				+ "BOARD_CONTENT,BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,"
				+ "BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE from "
				+ "(select * from board order by BOARD_RE_REF desc,BOARD_RE_SEQ asc) AS s)AS u " + "where rnum>=? and rnum<=?";
		
		ArrayList<BDto> list = new ArrayList<BDto>(); // ���� ���� �� ��� ���� ��� ���� ArrayList������ list ���� ���� 

		int startrow = (page - 1) * 10 + 1; // �б� ������ row��ȣ
		int endrow = startrow + limit - 1; // �б� ������ row��ȣ.
		
		return (ArrayList<BDto>)template.query(sql, new Object[] {startrow, endrow}, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}

	public int getListCount() {
		// �Խ��� ����Ʈ ���� ���ϱ� 
		int x = 0; // �ʱ�ȭ 
		
		String sql = "select count(*) from board";
		
		return template.queryForObject(sql, Integer.class);
	}

	public void setReadCountUpdate(final int num) {
		// ��ȸ�� �����ϱ�
		String sql="update board set BOARD_READCOUNT = "+
				"BOARD_READCOUNT+1 where BOARD_NUM = ?";
		
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, num);
			}
			
		});
		
	}

	public BDto getDetail(int num) {
		// �Խñ� �󼼺���
		BDto board = null;
		
		setReadCountUpdate(num);
		
		String sql = "select * from board where BOARD_NUM = "+num;
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}

	public boolean isBoardWriter(int num, String board_pass) {
		// �Խñ� �ۼ��� Ȯ���ϱ�
		
		String board_sql="select * from board where BOARD_NUM=?";
		
		BDto dto = template.queryForObject(board_sql, new Object[] {num}, new BeanPropertyRowMapper<BDto>(BDto.class)); 

		if(dto!=null && board_pass.equals(dto.getBOARD_PASS())) {
			return true;
		}
		
		return false;
	}

	public boolean boardModify(final BDto boarddata) {
		// �Խñ� �����ϱ�
		String sql="update board set BOARD_SUBJECT=?,BOARD_CONTENT=? where BOARD_NUM=?";
		
		int result = this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, boarddata.getBOARD_SUBJECT());
				ps.setString(2, boarddata.getBOARD_CONTENT());
				ps.setInt(3, boarddata.getBOARD_NUM());
			}
		});
		
		if(result==0) {
			System.out.println("�Խñ� update ����");
		}
		
		return result>0;

	}

	public boolean boardInsert(final BDto boarddata) {
		// �ۼ��� �Խñ� insert �ϱ�
		int result=0;
		
		result = this.template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				int maxCount = 0;
				
				String sql="select max(board_num) from board";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					maxCount = rs.getInt("max(board_num)")+1; 
				}else {
					maxCount = 1;
				}
				
				String sql2 = "insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
				sql2 += "BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF,"+
						"BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"+
						"BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";
				
				pstmt = con.prepareStatement(sql2);
				pstmt.setInt(1, maxCount);
				pstmt.setString(2, boarddata.getBOARD_NAME());
				pstmt.setString(3, boarddata.getBOARD_PASS());
				pstmt.setString(4, boarddata.getBOARD_SUBJECT());
				pstmt.setString(5, boarddata.getBOARD_CONTENT());
				pstmt.setString(6, boarddata.getBOARD_FILE());
				pstmt.setInt(7, maxCount);
				pstmt.setInt(8, 0);
				pstmt.setInt(9, 0);
				pstmt.setInt(10, 0);
				
				return pstmt;
			}});
		return result > 0;
		
	}

	public boolean boardDelete(final int num) {
		// ������ �Խñ� db���� delete�ϱ� 
		String board_delete_sql="delete from board where BOARD_num=?";
		
		int result=0;
		
		result = this.template.update(board_delete_sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, num);
			}
		});
		
		return result > 0;

	}

	public int boardReply(final BDto boarddata) {
		// �Խñ� �亯 db�� insert�ϱ�
		int num=0;
		int result=0;
		
		// max(board_num)�� ã�� ���� ���� ������ ����
		String board_max_sql="select max(board_num) from board";
		Integer maxNum = this.template.queryForObject(board_max_sql, Integer.class);
		num = (maxNum==null)?1:maxNum+1;
		
		String update_sql="update board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? ";
		update_sql+="and BOARD_RE_SEQ>?";
		template.update(update_sql, boarddata.getBOARD_RE_REF(), boarddata.getBOARD_RE_LEV());
		
		int newRe_seq = boarddata.getBOARD_RE_SEQ() + 1;
		int newRe_lev = boarddata.getBOARD_RE_LEV()+1;
		
		// �Խñ� �亯�� insert �ϴ� ���� ���� 
		String insert_sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
		insert_sql+="BOARD_CONTENT, BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,";
		insert_sql+="BOARD_READCOUNT,BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,curdate())";
		template.update(insert_sql, new Object[] {num, boarddata.getBOARD_NAME(), boarddata.getBOARD_PASS(), boarddata.getBOARD_SUBJECT(), boarddata.getBOARD_CONTENT(), 
				"", boarddata.getBOARD_RE_REF(), newRe_lev, newRe_seq, 0});
		

		System.out.println("���Ⱑ update�� �Խñ� ��ȣ��: "+num);
		return num; // update�� �Խñ� ��ȣ�� ��ȯ
		
	}

}
