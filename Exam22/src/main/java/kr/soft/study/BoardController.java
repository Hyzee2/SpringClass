package kr.soft.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/view")
	public String home() {
		return "board/view";
	}
	
	// Model�� �۾��ϱ� 
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String data(Model model) { // Model�� �Ű������� �־��ָ� �ڵ����� ������ �ȴ�. Model�� �����͸� ���� �� �ִ� �׸�! 
		model.addAttribute("id", 30);
		model.addAttribute("name", "��ٹ�");
		return "board/Content"; // ������ jsp �� �̸� 
	}
	
	// ModelAndView�� �۾��ϱ� 
	@RequestMapping("/reply")
	public ModelAndView reply() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 500);
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping("/confirmId") // ����Ʈ ���� get ������� �����Ǿ� �ִ�. 
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "board/confirmId";
	}
	
	@RequestMapping("/checkId") // ����Ʈ ���� get ������� �����Ǿ� �ִ�. 
	public String checkId(@RequestParam("id")String id, @RequestParam("pw")String pw, Model model) {
//		String id = httpServletRequest.getParameter("id");
//		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		return "board/checkId";
	}

}
