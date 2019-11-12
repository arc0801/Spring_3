package com.arc.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arc.s3.model.board.QnaVO;
import com.arc.s3.service.board.QnaService;
import com.arc.s3.util.Pager;
import com.arc.s3.util.Pager2;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping("qnaList")
	public void qnaList(Model model, Pager2 pager2) throws Exception {
		List<QnaVO> ar = qnaService.qnaList(pager2);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager2);
	}
}
