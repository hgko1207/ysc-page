package org.onsemiro.ysc.page.controller;

import org.onsemiro.ysc.page.domain.param.SearchParam;
import org.onsemiro.ysc.page.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	private NoticeService noticeService;

	/**
	 * 공지사항 화면
	 * @param model
	 */
	@GetMapping("list")
    public void list(Model model) {
    }
	
	/**
	 * 리스트 조회
	 * @param param
	 * @return
	 */
	@PostMapping("search")
    public ResponseEntity<?> search(@RequestBody SearchParam param) {
		return new ResponseEntity<>(noticeService.getList(param), HttpStatus.OK);
    }
}
