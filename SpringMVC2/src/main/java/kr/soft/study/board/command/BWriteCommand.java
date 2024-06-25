package kr.soft.study.board.command;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import kr.soft.study.dao.BDao;
import kr.soft.study.dto.BDto;
import kr.soft.study.user.command.Command;

public class BWriteCommand implements Command {

	@Override
	public void execute(Model model) {
		// �Խñ� �ۼ��� ���� db�� insert �ϱ�
		BDao boarddao = new BDao();
		BDto boarddata = new BDto();

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String saveFolder = "boardupload";

		// ServletContext�� null���� Ȯ��
		ServletContext context = request.getSession().getServletContext();
		System.out.println(context);
		if (context == null) {
			System.out.println("ServletContext is null");
			return;
		}

		String realFolder = "/library/upload/";
		System.out.println("Real folder: " + realFolder);

		boolean result = false;

		try {
			if (request instanceof MultipartHttpServletRequest) {
				MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;
				MultipartFile file = multi.getFile("BOARD_FILE");

				if (file != null && !file.isEmpty()) {
					String fileName = file.getOriginalFilename();
					String filePath = realFolder + File.separator + fileName;
					File dest = new File(filePath);
					file.transferTo(dest);
					boarddata.setBOARD_FILE(fileName);
				}
			} else {
				System.out.println("Request is not a MultipartHttpServletRequest");
			}

			boarddata.setBOARD_NAME(request.getParameter("BOARD_NAME"));
			boarddata.setBOARD_PASS(request.getParameter("BOARD_PASS"));
			boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));

			System.out.println("BOARD_NAME: " + boarddata.getBOARD_NAME());
			System.out.println("BOARD_FILE: " + boarddata.getBOARD_FILE());
			result = boarddao.boardInsert(boarddata);

			if (!result) {
				System.out.println("�Խñ� ��Ͽ� �����Ͽ����ϴ�.");
				model.addAttribute("error", "�Խñ� ��� ����!");
				model.addAttribute("url", "../board/boardWrite");
			} else {
				System.out.println("�Խñ� ��Ͽ� �����Ͽ����ϴ�.");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
