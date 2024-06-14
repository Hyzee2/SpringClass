package kr.soft.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.soft.study.bean.Student;
import kr.soft.study.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	// 이 아래 부분이 service 과제! 
	@Autowired
	StudentService ss;
	
	@RequestMapping(method = RequestMethod.POST, value = "/StudentView")
	public String infoService(Student student) {
		int result = ss.studentConfirm(student);
		System.out.println("[StudentController]에서 실행 " + result);
		return "student/studentView";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/info") // 컨트롤러에서 명확하게 명시! 
	public String infoGet(@RequestParam("studentId") String studentId, Model model) {
		model.addAttribute("studentId",studentId);
		System.out.println("get방식으로!");
		return "student/join";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/info") // 컨트롤러에서 명확하게 명시! 
	public String infoPost(@ModelAttribute("s") Student student) {
		System.out.println("post방식으로!");
		return "student/studentView";
	}
	
	
	@RequestMapping("/info/{studentId}") 
	public String getStudent(@PathVariable String studentId, Model model) {
		model.addAttribute("studentId",studentId);
		return "student/join";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "student/index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/studentConfirm")
	public String choice(@RequestParam String id) {
		if(id.equals("abc")) {
			return "redirect:studentOk";
		}
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String Ok() {
		return "student/studentOk";
	}
	
	@RequestMapping("/studentNg")
	public String Ng() {
		return "student/studentNg";
	}
	
}
