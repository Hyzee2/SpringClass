//package kr.soft.study.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//
//import kr.soft.study.dto.BDto;
//import kr.soft.study.util.Constant;
//
//public class BDao {
//	
//	JdbcTemplate template;
//	
//	public BDao() { // 생성자에서 DB연결 하도록 
//		this.template = Constant.template;
//	}
//	
//	public ArrayList<BDto> list() {
//		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent "
//				+"from mvc_board order by bGroup desc, bStep asc";
//		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//		// BeanPropertyRowMapper는 지정된 클래스의 필드와 동일한 이름을 가진 데이터베이스 컬럼을 자동으로 매핑해준다. 
//	}
//
//	public BDto contentView(String bId) {
//		// TODO Auto-generated method stub
//		upHit(bId);
//		
//		String query = "select * from mvc_board where bId=" + bId;
//		
//		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//	}
//
//	private void upHit(final String bId) {
//		// TODO Auto-generated method stub
//		String query = "update mvc_board set bHit = bHit+1 where bId=?";
//		
//		this.template.update(query, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException{
//				ps.setInt(1, Integer.parseInt(bId));
//			}
//		});
//	}
//
//	public void delete(final String bId) {
//		// TODO Auto-generated method stub
//		String query = "delete from mvc_board where bId=?";
//		
//		this.template.update(query, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException{
//				ps.setString(1, bId);
//			}
//		});
//		
//	}
//
//	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
//		// TODO Auto-generated method stub
//		String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
//		
//		this.template.update(query, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, bName);
//				ps.setString(2, bTitle);
//				ps.setNString(3, bContent);
//				ps.setInt(4, Integer.parseInt(bId));
//			}
//		});
//	}
//
//	public void reply(final String bId, final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep,
//			final String bIndent) {
//		// TODO Auto-generated method stub
//		
//		replyShape(bGroup, bStep);
//		
//		String query = "insert into mvc_board (bName, bTitle, bContent, bGroup, bStep, bIndent) values (?,?,?,?,?,?)";
//		
//		this.template.update(query, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException{
//				ps.setString(1, bName);
//				ps.setString(2, bTitle);
//				ps.setString(3, bContent);
//				ps.setInt(4, Integer.parseInt(bGroup));
//				ps.setInt(5, Integer.parseInt(bStep)+1);
//				ps.setInt(6, Integer.parseInt(bIndent)+1);
//			}
//		});
//		// 이렇게 쓰는 이유는 파라미터 값이 Integer.parseInt()처럼 계산된 결과를 사용해야 할 때 
//		
//	}
//
//	private void replyShape(final String bGroup, final String bStep) {
//		// TODO Auto-generated method stub
//		String query = "update mvc_board set bStep = bStep+1 where bGroup =? and bStep>?";
//		
//		this.template.update(query, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException{
//				ps.setString(1, bGroup);
//				ps.setString(2, bStep);
//			}
//		});
//	}
//
//	public BDto reply_view(String bId) {
//		// TODO Auto-generated method stub
//		
//		String query = "select * from mvc_board where bId=" + bId;
//		
//		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//	}
//
//	public void write(final String bName, final String bTitle, final String bContent) {
//		// TODO Auto-generated method stub
//		this.template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				String sql = "select ifnull(max(bId)+1, 1) as BID from mvc_board";
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();
//				int maxCount = 0;
//				if(rs.next()) {
//					maxCount = rs.getInt("BID"); // 쿼리문에서 별칭으로 적어준다. 
//				}
//				
//				String query = "insert into mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent)"
//						+" values (?,?,?,?,0,?,0,0)";
//				pstmt = con.prepareStatement(query);
//				pstmt.setInt(1, maxCount);
//				pstmt.setString(2, bName);
//				pstmt.setString(3, bTitle);
//				pstmt.setString(4, bContent);
//				pstmt.setInt(5, maxCount);
//				
//				return pstmt;
//			}
//		});
//	}
//
//}
