package org.onsemiro.ysc.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
    public String index(Model model) {
		 return "redirect:home";
    }
	
	@GetMapping("home")
    public void home(Model model) {
    }
	
	/**
	 * 로그인 화면
	 * @param model
	 */
	@GetMapping("login")
    public void login(Model model) {
    }
}
