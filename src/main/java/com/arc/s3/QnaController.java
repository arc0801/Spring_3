package com.arc.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arc.s3.model.board.QnaVO;
import com.arc.s3.service.board.QnaService;
import com.arc.s3.util.Pager;
import com.arc.s3.util.Pager2;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public String qnaReply(QnaVO qnaVO) throws Exception {
		int result = qnaService.qnaReply(qnaVO);
		return "redirect:./qnaList";
	}
	
	@RequestMapping("qnaReply")
	public void qnaReply(int num, Model model) throws Exception {
		model.addAttribute("num", num);
	}
	
	@RequestMapping("qnaSelect")
	public ModelAndView qnaSelect(int num) throws Exception {
		QnaVO qnaVO = qnaService.qnaSelect(num);
		ModelAndView mv = new ModelAndView();
		
		if(qnaVO != null) {
			mv.addObject("select", qnaVO);
			mv.setViewName("qna/qnaSelect");
		}else {
			mv.addObject("msg", "존재하지 않는 글번호입니다.");
			mv.addObject("path", "qnaList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaWrite(QnaVO qnaVO) throws Exception {
		int result = qnaService.qnaWrite(qnaVO);
		ModelAndView mv = new ModelAndView();
		
		if(result>0) {
			mv.addObject("msg", "Write Success");
		}else {
			mv.addObject("msg", "Write Fail");
		}
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("qnaWrite")
	public void qnaWrite() throws Exception {
		
	}
	
	@RequestMapping(value="qnaList", method = RequestMethod.GET)
	public void qnaList(Model model, Pager2 pager2) throws Exception {
		//데이터 들어오는지 Test
		//System.out.println(pager2.getKind());
		//System.out.println(pager2.getSearch());
				
		List<QnaVO> ar = qnaService.qnaList(pager2);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager2);
	}
}
