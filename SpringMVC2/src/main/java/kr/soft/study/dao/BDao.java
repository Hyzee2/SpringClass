package kr.soft.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
		
		BDto dto = template.queryForObject(board_sql, new Object[] {num}, BDto.class);
		if(dto!=null) {
			if(board_pass.equals(dto.getBOARD_PASS())) {
				return true;
			}
		}
		
//		try{
//			pstmt=con.prepareStatement(board_sql);
//			pstmt.setInt(1, num);
//			rs=pstmt.executeQuery();
//			rs.next();
//			
//			if(board_pass.equals(rs.getString("BOARD_PASS"))){
//				return true;
//			}
//		}catch(SQLException ex){
//			System.out.println("isBoardWriter ���� : " + ex);
//		}
		return false;
	}
//
//	public boolean boardModify(BDto boarddata) {
//		// �Խñ� �����ϱ�
//		String sql="update board set BOARD_SUBJECT=?,BOARD_CONTENT=? where BOARD_NUM=?";
//		
//		try{
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, boarddata.getBOARD_SUBJECT());
//			pstmt.setString(2, boarddata.getBOARD_CONTENT());
//			pstmt.setInt(3, boarddata.getBOARD_NUM());
//			pstmt.executeUpdate();
//			return true;
//		}catch(Exception ex){
//			System.out.println("boardModify ���� : " + ex);
//		}finally{
//			if(rs!=null)try{rs.close();}catch(SQLException ex){}
//			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
//			}
//		return false;
//	}
//
//	public boolean boardInsert(BDto boarddata) {
//		// �ۼ��� �Խñ� insert �ϱ�
//		int num =0;
//		String sql="";
//		
//		int result=0;
//		
//		try{
//			pstmt=con.prepareStatement("select max(board_num) from board");
//			rs = pstmt.executeQuery();
//			
//			if(rs.next())
//				num =rs.getInt(1)+1; // ���� ������ ��ȣ +1
//			else
//				num=1;
//			
//			sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
//			sql+="BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF,"+
//				"BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"+
//				"BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			pstmt.setString(2, boarddata.getBOARD_NAME());
//			pstmt.setString(3, boarddata.getBOARD_PASS());
//			pstmt.setString(4, boarddata.getBOARD_SUBJECT());
//			pstmt.setString(5, boarddata.getBOARD_CONTENT());
//			pstmt.setString(6, boarddata.getBOARD_FILE());
//			pstmt.setInt(7, num);
//			pstmt.setInt(8, 0);
//			pstmt.setInt(9, 0);
//			pstmt.setInt(10, 0);
//			
//			result=pstmt.executeUpdate();
//			if(result==0) {return false;} // �������� ���, result ��ȯ���� 0  
//			
//			return true;
//		}catch(Exception ex){
//			System.out.println("boardInsert ���� : "+ex);
//		}finally{
//			if(rs!=null) try{rs.close();}catch(SQLException ex){}
//			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
//		}
//		return false;
//		
//	}
//
//	public boolean boardDelete(int num) {
//		// ������ �Խñ� db���� delete�ϱ� 
//		String board_delete_sql="delete from board where BOARD_num=?";
//		
//		int result=0;
//		
//		try{
//			pstmt=con.prepareStatement(board_delete_sql);
//			pstmt.setInt(1, num);
//			result=pstmt.executeUpdate();
//			if(result==0) {return false;}
//			
//			return true;
//		}catch(Exception ex){
//			System.out.println("boardDelete ���� : "+ex);
//		}finally{
//			try{
//				if(pstmt!=null)pstmt.close();
//			}catch(Exception ex) {}
//		}
//		
//		return false;
//	}
//
//	public int boardReply(BDto boarddata) {
//		// �Խñ� �亯 db�� insert�ϱ�
//		String board_max_sql="select max(board_num) from board";
//		String sql="";
//		int num=0;
//		int result=0;
//		
//		int re_ref=boarddata.getBOARD_RE_REF();
//		int re_lev=boarddata.getBOARD_RE_LEV();
//		int re_seq=boarddata.getBOARD_RE_SEQ();
//		
//		try{
//			pstmt=con.prepareStatement(board_max_sql);
//			rs = pstmt.executeQuery();
//			if(rs.next())num =rs.getInt(1)+1;
//			else num=1;
//			
//			sql="update board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? ";
//			sql+="and BOARD_RE_SEQ>?";
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1,re_ref);
//			pstmt.setInt(2,re_seq);
//			result=pstmt.executeUpdate();
//			
//			re_seq = re_seq + 1;
//			re_lev = re_lev+1;
//			
//			sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
//			sql+="BOARD_CONTENT, BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,";
//			sql+="BOARD_READCOUNT,BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,curdate())";
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			pstmt.setString(2, boarddata.getBOARD_NAME());
//			pstmt.setString(3, boarddata.getBOARD_PASS());
//			pstmt.setString(4, boarddata.getBOARD_SUBJECT());
//			pstmt.setString(5, boarddata.getBOARD_CONTENT());
//			pstmt.setString(6, ""); 
//			pstmt.setInt(7, re_ref);
//			pstmt.setInt(8, re_lev);
//			pstmt.setInt(9, re_seq);
//			pstmt.setInt(10, 0);
//			pstmt.executeUpdate();
//			return num; // �Խñ� ��ȣ�� ��ȯ
//		}catch(SQLException ex){
//			System.out.println("boardReply ���� : "+ex);
//		}finally{
//			if(rs!=null)try{rs.close();}catch(SQLException ex){}
//			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
//		}
//		return 0;
//	}

}
