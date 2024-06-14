package kr.soft.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.soft.study.bean.Member;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping("/join") 
	public String join(HttpServletRequest httpServletRequest, Model model) {
		String name = httpServletRequest.getParameter("name");
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		String email = httpServletRequest.getParameter("email");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("email", email);
		return "member/join";
	}
	
	@RequestMapping("/join2") 
	public String join2(@RequestParam String name, @RequestParam String id, @RequestParam String pw, @RequestParam String email, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("email", email);
		return "member/join";
	}
	
	@RequestMapping("/join3") 
	public String join3(@RequestParam String name, @RequestParam String id, @RequestParam String pw, @RequestParam String email, Model model) {
		Member m = new Member();
		m.setName(name);
		m.setId(id);
		m.setPw(pw);
		m.setEmail(email);
		model.addAttribute("member", m);
		return "member/join";
	}
	
	@RequestMapping("/join4")
	public String join4(Member member) {
		return "member/join";
	}

}
