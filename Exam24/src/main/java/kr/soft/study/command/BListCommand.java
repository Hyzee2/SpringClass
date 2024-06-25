package kr.soft.study.command;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import kr.soft.study.dao.BoardDao;
import kr.soft.study.dto.BDto;
import kr.soft.study.util.Constant;

public class BListCommand implements BCommand {
	
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("list", Constant.dao.list());
//		BDao dao = new BDao();
//		ArrayList<BDto> dtos = dao.list();
//		model.addAttribute("list", dtos);

	}

}
