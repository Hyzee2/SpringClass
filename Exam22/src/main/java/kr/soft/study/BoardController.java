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
	
	// Model로 작업하기 
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String data(Model model) { // Model은 매개변수로 넣어주면 자동으로 생성이 된다. Model은 데이터를 담을 수 있는 그릇! 
		model.addAttribute("id", 30);
		model.addAttribute("name", "김근미");
		return "board/Content"; // 실제로 jsp 뷰 이름 
	}
	
	// ModelAndView로 작업하기 
	@RequestMapping("/reply")
	public ModelAndView reply() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 500);
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping("/confirmId") // 디폴트 값은 get 방식으로 설정되어 있다. 
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "board/confirmId";
	}
	
	@RequestMapping("/checkId") // 디폴트 값은 get 방식으로 설정되어 있다. 
	public String checkId(@RequestParam("id")String id, @RequestParam("pw")String pw, Model model) {
//		String id = httpServletRequest.getParameter("id");
//		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		return "board/checkId";
	}

}
