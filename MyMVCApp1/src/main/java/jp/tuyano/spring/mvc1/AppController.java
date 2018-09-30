package jp.tuyano.spring.mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@RequestMapping("/msg") 
	public String message(Model model) {
		model.addAttribute("msg", "This is message from contorller!");
		
		return "showMessage";
	}
	
	@RequestMapping(value="/post" ,method=RequestMethod.POST)
	public ModelAndView postForm(@RequestParam("text1") String text1) {
		ModelAndView mv = new ModelAndView("showMessage");
		mv.addObject("msg" ,"you are write '" + text1 + "'");
		return mv;
	}
	
}
