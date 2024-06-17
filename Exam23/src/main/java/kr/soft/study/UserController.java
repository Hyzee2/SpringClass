package kr.soft.study;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/user/userJoin")
	public String userForm() {
		return "user/userJoin";
	}
	
	// 1. validator implements하는 방법 
//	@RequestMapping("/user/joinConfirm")
//	public String confirm(@ModelAttribute("u") User user, BindingResult result) {
//		String page = "user/userInfo";
//		
//		UserValidator validator = new UserValidator();
//		validator.validate(user, result);
//		if(result.hasErrors()) {
//			page = "user/userJoin";
//		}
//		return page;
//	}
	
	// 3. annotation을 이용하는 방법
	@RequestMapping("/user/joinConfirm")
	public String confirm(@ModelAttribute("u") @Valid User user, BindingResult result) {
		String page = "user/userInfo";
		
		if(result.hasErrors()) {
			page = "user/userJoin";
		}
		
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}

}
