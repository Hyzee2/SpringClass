package kr.soft.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AController {
	@RequestMapping("/admin_main") // 관리자 메인 페이지 보여주기
	public String main() {
		return "admin/adminList";
	}
}
