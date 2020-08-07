package org.onsemiro.ysc.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 알립니다(공지사항) 화면 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("notice")
public class NoticeController {

	/**
	 * 공지사항 화면
	 * @param model
	 */
	@GetMapping("list")
    public void list(Model model) {
    }
}
