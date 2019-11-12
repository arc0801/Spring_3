package com.arc.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arc.s3.model.board.QnaVO;
import com.arc.s3.service.board.QnaService;
import com.arc.s3.util.Pager;
import com.arc.s3.util.Pager2;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value="qnaList", method = RequestMethod.GET)
	public void qnaList(Model model, Pager2 pager2) throws Exception {
		//데이터 들어오는지 Test
		//System.out.println(pager2.getKind());
		//System.out.println(pager2.getSearch());
				
		List<QnaVO> ar = qnaService.qnaList(pager2);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager2);
	}
	
	@RequestMapping("qnaWrite")
	public void qnaInsert() throws Exception {
		
	}
}
