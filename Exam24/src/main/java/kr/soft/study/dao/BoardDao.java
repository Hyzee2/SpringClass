package kr.soft.study.dao;

import java.util.ArrayList;

import kr.soft.study.dto.BDto;

public interface BoardDao {
	
	public ArrayList<BDto> list();
	public BDto contentView(String bId);
	public void upHit(String bId);
	public void delete(final String bId);
	public void modify(String bName, String bTitle, String bContent, String bId);
	public void reply(String bName, String bTitle, String bContent, String bGroup, int bStep,
			int bIndent);
	public void replyShape(String bGroup, String bStep);
	public BDto reply_view(String bId);
	public int selectNextBId();
	public void insertBoard(int bId, String bName, String bTitle, String bContent);

}
