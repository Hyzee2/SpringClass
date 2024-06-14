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
	
	// �� �Ʒ� �κ��� service ����! 
	@Autowired
	StudentService ss;
	
	@RequestMapping(method = RequestMethod.POST, value = "/StudentView")
	public String infoService(Student student) {
		int result = ss.studentConfirm(student);
		System.out.println("[StudentController]���� ���� " + result);
		return "student/studentView";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/info") // ��Ʈ�ѷ����� ��Ȯ�ϰ� ���! 
	public String infoGet(@RequestParam("studentId") String studentId, Model model) {
		model.addAttribute("studentId",studentId);
		System.out.println("get�������!");
		return "student/join";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/info") // ��Ʈ�ѷ����� ��Ȯ�ϰ� ���! 
	public String infoPost(@ModelAttribute("s") Student student) {
		System.out.println("post�������!");
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
