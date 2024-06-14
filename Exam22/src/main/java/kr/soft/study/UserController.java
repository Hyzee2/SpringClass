package kr.soft.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.soft.study.bean.User;

import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/joinAction") // 컨트롤러에서 명확하게 명시! 
	public String info(User user) {
		System.out.println("post방식으로!");
		return "user/info";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/joinOne")
	public String infoOne(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		String mail = httpServletRequest.getParameter("mail");
		String name = httpServletRequest.getParameter("name");
		String IDnum = httpServletRequest.getParameter("IDnum");
		String[] birth = httpServletRequest.getParameterValues("birth");
		String[] hobby = httpServletRequest.getParameterValues("hobby");
		String introduction = httpServletRequest.getParameter("introduction");
		
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("id", id);
		user.put("pw", pw);
		user.put("mail", mail);
		user.put("name", name);
		user.put("IDnum", IDnum);
		user.put("birth", birth);
		user.put("hobby", hobby);
		user.put("introduction", introduction);
		
		model.addAllAttributes(user);
		
		return "user/info";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/joinTwo")
	public String joinTwo(@RequestParam String id,@RequestParam String pw, @RequestParam String mail, @RequestParam String name, @RequestParam String IDnum, @RequestParam String birth, @RequestParam String hobby, @RequestParam String introduction, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("mail", mail);
		model.addAttribute("name", name);
		model.addAttribute("IDnum", IDnum);
		model.addAttribute("birth", birth);
		model.addAttribute("hobby", hobby);
		model.addAttribute("introduction", introduction);
		return "user/info";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/joinThree")
	public String joinThree(@RequestParam String id,@RequestParam String pw, @RequestParam String mail, @RequestParam String name, @RequestParam String IDnum, @RequestParam String birth, @RequestParam String hobby, @RequestParam String introduction, Model model) {
		User user = new User();
		user.setId(id);
		user.setPw(pw);
		user.setMail(mail);
		user.setName(name);
		user.setIDnum(IDnum);
		user.setBirth(birth);
		user.setHobby(hobby);
		user.setIntroduction(introduction);
		model.addAttribute("user", user);
		return "user/info";
		                                                                                                      
	}
	
}
