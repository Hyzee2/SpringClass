package kr.soft.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.soft.study.dto.BaDto;

public class BaDao {
	
	static Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BaDao() {
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

	public boolean basketAdd(BaDto basketdata) {
		// 장바구니 db에 담은 제품들은 insert 하기 
		String item_name ="";
		String sql="";
		
		int result=0;
		
		try{
			pstmt=con.prepareStatement("select * from basket where id=? and item_name=?");
			pstmt.setString(1, basketdata.getId());
			pstmt.setString(2, basketdata.getItem_name());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				item_name = rs.getString("item_name");
				System.out.println("상품이름은 "+item_name );
				
				if(item_name != null) {
				
					sql = "update basket set item_total=item_total+? where id=? and item_name=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, basketdata.getItem_total());
					pstmt.setString(2, basketdata.getId());
					pstmt.setString(3, basketdata.getItem_name());
					result=pstmt.executeUpdate();
					pstmt.close();
				}
			
			}else{
				
				sql = "insert into basket (id, item_name, item_price, item_total) values(?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, basketdata.getId());
				pstmt.setString(2, basketdata.getItem_name());
				pstmt.setString(3, basketdata.getItem_price());
				pstmt.setString(4, basketdata.getItem_total());
				result=pstmt.executeUpdate();
			}
			
			if(result==0) { 
				
				return false;
			}else {
				System.out.println("basketAdd 성공");
				return true;
			}
		}catch(Exception ex){
			System.out.println("basketAdd 실패 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return false;
	}

	public ArrayList<BaDto> basketList(String id) {
		// 장바구니 내역 select 하기 
		String basket_list_sql = "select * from basket where id = ?";

		ArrayList<BaDto> list = new ArrayList<BaDto>(); 
		try {
			pstmt = con.prepareStatement(basket_list_sql);
			pstmt.setString(1, id); // where 조건절에서 첫번째 ? 설정
			
			rs = pstmt.executeQuery();

			while (rs.next()) { 
				BaDto basket = new BaDto();
				
				basket.setId(rs.getString("id"));
				basket.setItem_name(rs.getString("item_name"));
				basket.setItem_price(rs.getString("item_price"));
				basket.setItem_total(rs.getString("item_total"));
				list.add(basket); 
			}

			return list; // 결과 값들을 담은 list 반환 
		} catch (Exception ex) {
			System.out.println("getBasketList 에러 : " + ex);
			
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

	public boolean basketModify(BaDto basketdata) {
		// DB에 변경된 장바구니 수량 update
		String sql="update basket set item_total=? where id=? and item_name=?";
		
		try{
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, basketdata.getItem_total());
			pstmt.setString(2, basketdata.getId());
			pstmt.setString(3, basketdata.getItem_name());
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("basketModify 실패 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			}
		return false;
	}

}
