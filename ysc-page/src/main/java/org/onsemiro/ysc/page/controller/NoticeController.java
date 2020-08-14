package org.onsemiro.ysc.page.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.tomcat.util.codec.binary.Base64;
import org.onsemiro.ysc.page.domain.EnumType.FileType;
import org.onsemiro.ysc.page.domain.db.Notice;
import org.onsemiro.ysc.page.domain.db.NoticeFile;
import org.onsemiro.ysc.page.domain.param.SearchParam;
import org.onsemiro.ysc.page.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 * 공지사항 상세정보 화면
	 * @param model
	 */
	@GetMapping("detail/{id}")
	public String detail(Model model, @PathVariable int id) {
		Notice notice = noticeService.get(id);
		model.addAttribute("notice", notice);
		
		List<NoticeFile> images = notice.getFiles().stream().map(data -> {
			if (data.getContentType().contains(FileType.PDF.getName())) {
				data.setImage(Base64.encodeBase64String(data.getContent()));
				data.setImages(convertPDFtoImage(data.getContent()));
			} else {
				data.setImage(Base64.encodeBase64String(data.getContent()));
			}
			return data;
		}).collect(Collectors.toList());
		model.addAttribute("images", images);
		
		notice.setHit(notice.getHit() + 1);
		noticeService.update(notice);
		
		return "notice/detail";
	}
	
	private List<String> convertPDFtoImage(byte[] bytesPDF) {
		List<String> imageDatas = new ArrayList<>();
		
        try {
        	InputStream inputStream = new ByteArrayInputStream(bytesPDF);
        	PDDocument document = PDDocument.load(inputStream);
        	PDFRenderer renderer = new PDFRenderer(document);
        	
        	for (int page = 0; page < document.getNumberOfPages(); page++) {
        		ByteArrayOutputStream out = new ByteArrayOutputStream();
        		BufferedImage image = renderer.renderImageWithDPI(page, 96, ImageType.RGB);
            	ImageIO.write(image , "jpg", out);
            	imageDatas.add(Base64.encodeBase64String(out.toByteArray()));
            	out.close();
        	}

        	document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return imageDatas;
    }
}
