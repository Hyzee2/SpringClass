package kr.soft.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AController {
	@RequestMapping("/admin_main") // ������ ���� ������ �����ֱ�
	public String main() {
		return "admin/adminList";
	}
}
