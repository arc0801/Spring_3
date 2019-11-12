package com.arc.s3;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arc.s3.model.board.NoticeVO;
import com.arc.s3.service.board.NoticeService;
import com.arc.s3.util.Pager;
import com.arc.s3.util.Pager2;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Inject
	private NoticeService noticeService;
	
	@RequestMapping("noticeDelete")
	public ModelAndView noticeDelete(int num) throws Exception {
		int result = noticeService.noticeDelete(num);
		ModelAndView mv = new ModelAndView();
		//result = 0;
		if(result>0) {
			mv.addObject("msg", "Delete Success");
		}else {
			mv.addObject("msg", "Delete Fail");
		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeVO noticeVO) throws Exception {
		int result = noticeService.noticeUpdate(noticeVO);
		ModelAndView mv = new ModelAndView();
		
		//result = 0;
		if(result>0) {
			mv.addObject("msg", "Update Success");
		}else {
			mv.addObject("msg", "Update Fail");
		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("noticeUpdate")
	public void noticeUpdate(Model model, int num) throws Exception {
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		model.addAttribute("update", noticeVO);
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeVO noticeVO) throws Exception  {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeInsert(noticeVO);
		
		if(result>0) {
			mv.addObject("msg", "Write Success");
		}else {
			mv.addObject("msg", "Write Fail");
		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("noticeWrite")
	public void noticeWrite() throws Exception  {
	}
	
	@RequestMapping("noticeSelect")
	public ModelAndView noticeSelect(int num) throws Exception {
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		ModelAndView mv = new ModelAndView();
		
		if(noticeVO == null) {
			mv.addObject("msg", "존재하지 않는 글번호입니다.");
			mv.addObject("path", "noticeList");
			mv.setViewName("common/common_result");
		}else {
			mv.addObject("select", noticeVO);
			mv.setViewName("notice/noticeSelect");
		}
		return mv;
	}
	
	//list : /notice/noticeList GET
	//view : /WEB-INF/views/notice/noticeList.jsp
	@RequestMapping("noticeList")
	public void noticeList(Model model, Pager2 pager2) throws Exception {
		List<NoticeVO> ar = noticeService.noticeList(pager2);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager2);
	}
	
}
