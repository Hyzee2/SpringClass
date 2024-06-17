package kr.soft.study;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	@RequestMapping("/loginForm")
	public String form() {
		return "createPage";
	}
	
//	@RequestMapping("/login")
//	public String logIn(@ModelAttribute("s") Student student, BindingResult result) {
//		String page = "createDonePage"; // 정상적일 때 반환할 뷰 페이지
//		
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result); //유효성 검사
//		if(result.hasErrors()) {
//			System.out.println("이름 혹은 아이디가 유효하지 않습니다.");
//			page = "createPage";
//		}
//		return page;
//	}
	
	@RequestMapping("/login")
	public String studentCreate(@ModelAttribute("s") @Valid Student student, BindingResult result){
		String page = "createDonePage";
		
		if(result.hasErrors()) {
			page = "createPage";
		}
		
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}

}
