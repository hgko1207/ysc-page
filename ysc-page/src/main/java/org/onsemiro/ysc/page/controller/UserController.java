package org.onsemiro.ysc.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 시작해요(로그인) 화면 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

	/**
	 * 회원가입 화면
	 * @param model
	 */
	@GetMapping("signup")
    public void signup(Model model) {
    }

	/**
	 * 비밀번호 찾기 화면
	 * @param model
	 */
	@GetMapping("password")
    public void password(Model model) {
    }
}
