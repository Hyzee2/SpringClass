package kr.soft.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OutController {
	
	@RequestMapping("/studentURL1") // WEB-INF에 있는 studentURL1.jsp 
	public String studentURL1(Model model) {
		return "redirect:http://localhost:8080/study/studentURL1.jsp";
	}
	
	@RequestMapping("/student/studentURL1") // views에 있는 studentURL1.jsp
	public String studentURL11(Model model) {
		return "student/studentURL1";
	}
	
	@RequestMapping("/studentURL2")
	public String studentURL2(Model model) {
		return "redirect:student/studentURL2";
	}
	
	@RequestMapping("/student/studentURL2") //WEB-INF에 있는 studentURL2.jsp
	public String studentURL22(Model model) {
		return "redirect:http://localhost:8080/study/studentURL2.jsp";
	}

}
