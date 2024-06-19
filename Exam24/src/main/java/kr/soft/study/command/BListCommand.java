package kr.soft.study.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import kr.soft.study.dao.BDao;
import kr.soft.study.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);

	}

}
