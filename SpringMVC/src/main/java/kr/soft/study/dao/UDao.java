package kr.soft.study.dao;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class UDao {
	
	static Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public UDao() {
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MysqlDB");
			
			if(con == null)
				con = ds.getConnection();
			
			System.out.println("연결되었습니다.");
		}catch(Exception e){
			System.out.println("연결에 실패하였습니다.");
			e.printStackTrace();
			return;
		}
	}

	public boolean join(final String id, final String pw, final String mail, final String name, final String IDnum, final String birth, final String hobby,
			final String introduction) {
		// 회원가입 정보 insert
		
		String sql="";
		
		int result=0;
		
		try{
			sql="Insert into user values (?,?,?,?,?,?,?,?)";		
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, mail);
			pstmt.setString(4, name);
			pstmt.setString(5, IDnum);
			pstmt.setString(6, birth);
			pstmt.setString(7, hobby);
			pstmt.setString(8, introduction);
			
			result=pstmt.executeUpdate();
			if(result==0) {
				return false; 
			}else {
				return true;
			}
		}catch(Exception ex){
			System.out.println("회원 정보 등록 실패 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return false;
	}

	public int loginCheck(String id, String pw) throws SQLException {
		// 로그인한 id, pw 비교하기 
		String sql="";
		sql = "select id, pw from user";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(id.equals("admin") && pw.equals("1234")) {
					return 0; // 관리자 
				}
				if(rs.getString("id").equals(id) && rs.getString("pw").equals(pw)) {
					return 1; // 회원 
				}
			}
			
		}catch(Exception e) {
			System.out.println("로그인 조회 오류");
			e.printStackTrace();
		}
		finally {
			pstmt.close();
			con.close();
		}
		return -1; // 비회원 
	}
	

}
