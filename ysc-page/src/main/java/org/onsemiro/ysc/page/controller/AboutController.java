package org.onsemiro.ysc.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 궁금해요(회사소개) 화면 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("about")
public class AboutController {

	/**
	 * Firmly accomplish 화면
	 * @param model
	 */
	@GetMapping("accomplish")
    public void accomplish(Model model) {
    }
	
	/**
	 * Already 25 year 화면
	 * @param model
	 */
	@GetMapping("already")
    public void already(Model model) {
    }
	
	/**
	 * family 화면
	 * @param model
	 */
	@GetMapping("family")
    public void family(Model model) {
    }
	
	/**
	 * Location YSC 화면
	 * @param model
	 */
	@GetMapping("location")
    public void location(Model model) {
    }
}
