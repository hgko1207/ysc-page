package org.onsemiro.ysc.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 함께해요(게시판) 화면 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("board")
public class BoardController {

	/**
	 * 알립니다 화면
	 * @param model
	 */
	@GetMapping("inform")
    public void inform(Model model) {
    }
	
	/**
	 * 신청합니다 화면
	 * @param model
	 */
	@GetMapping("apply")
    public void apply(Model model) {
    }
	
	/**
	 * 궁금합니다 화면
	 * @param model
	 */
	@GetMapping("wonder")
    public void wonder(Model model) {
    }
	
	/**
	 * 자랑합니다 화면
	 * @param model
	 */
	@GetMapping("boast")
    public void boast(Model model) {
    }
}
