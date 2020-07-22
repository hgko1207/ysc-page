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
	 * 함께해요 화면
	 * @param model
	 */
	@GetMapping("together")
    public void together(Model model) {
    }
}
