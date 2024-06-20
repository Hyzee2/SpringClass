package kr.soft.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.soft.study.dto.UDto;

public class ADao {
	
	static Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ADao() {
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MysqlDB");
			
			if(con == null)
				con = ds.getConnection();
			
			System.out.println("����Ǿ����ϴ�.");
		}catch(Exception e){
			System.out.println("���ῡ �����Ͽ����ϴ�.");
			e.printStackTrace();
			return;
		}
	}

	public List<String> adminList() {
		// DB���� user ��� select �ϴ� ���
		String user_id = "";
		String sql = "select id from user";

		List<String> list = new ArrayList<String>(); 
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while (rs.next()) { 
				
				user_id = rs.getString("id");
				
				list.add(user_id); 
			}

			return list; // ��� ������ ���� list ��ȯ 
			
		} catch (Exception ex) {
			System.out.println("getUserList ���� : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return list;
		
	}

	public UDto adminDetail(String userId) {
		UDto user = null;
		System.out.println(userId);
		try{
			pstmt = con.prepareStatement(
					"select id, mail, name, IDnum, birth, hobby, introduction from user where id = ?");
			pstmt.setString(1, userId);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				user = new UDto();
				
				user.setId(rs.getString("id"));
				user.setMail(rs.getString("mail"));
				user.setName(rs.getString("name"));
				user.setIDnum(rs.getString("IDnum"));
				user.setBirth(rs.getString("birth"));
				user.setHobby(rs.getString("hobby"));
				user.setIntroduction(rs.getString("introduction"));
				
			}
			System.out.println("getDatail����: "+user.getName());
			return user;
		}catch(Exception ex){
			System.out.println("getDetail ���� : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt !=null)try{pstmt.close();}catch(SQLException ex){}
		}
		return null;
	}

	public boolean adminDelete(String userId) {
		// DB���� ���õ� ȸ�� delete �ϴ� ��� 
		String sql="delete from user where id=?";
		String sql2="delete from basket where id=?";
		
		int result=0;
		
		try{
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			result=pstmt.executeUpdate();
			
			if(result==0) {
				return false;
			}
			
			pstmt=con.prepareStatement(sql2);
			
			pstmt.setString(1, userId);
			result=pstmt.executeUpdate();
			
			if(result==0) {
				return false;
			}
			
			System.out.println("userDelete ����");
			
			return true;
		}catch(Exception ex){
			System.out.println("userDelete ���� : "+ex);
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex) {}
		}
		
		return false;
	}

}
