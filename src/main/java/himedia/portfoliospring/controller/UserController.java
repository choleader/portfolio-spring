package himedia.portfoliospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import himedia.portfoliospring.domain.UserDto;
import himedia.portfoliospring.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/board/join")
	public ModelAndView joinForm() {
		ModelAndView mv = new ModelAndView("join");
		return mv;
	}
	
	@PostMapping("/board/join")
	public ModelAndView join(@ModelAttribute UserDto userDto) {
		ModelAndView mv = new ModelAndView("redirect:/board");
		userService.join(userDto);
		return mv;
	}
	
	@PostMapping("/board/login")
	public ModelAndView login(@ModelAttribute UserDto userDto) {
		ModelAndView mv = new ModelAndView("redirect:/board");
		ModelAndView mv1 = new ModelAndView("login");
		
		if(userService.login(userDto))
			return mv;
		else
			return mv1;
	}
	
	@GetMapping("/board/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

}























