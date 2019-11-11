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
	public void noticeList(Model model, @RequestParam(required = false, defaultValue = "1") int curPage) throws Exception {
		Map<String, Object> map = noticeService.noticeList(curPage);
		
		List<NoticeVO> ar = (List<NoticeVO>)map.get("list");
		int totalPage = (Integer)map.get("totalPage"); //AutoUnboxing(Integer -> int)
		
		model.addAttribute("list", ar);
		model.addAttribute("totalPage", totalPage);
		//리턴타입이 void면 맵핑해놓은 주소와 같은 주소가 자동으로 리턴됨으로 모델을 매개변수로 받아서 넣어주기만 하면 됨
		//그러나 주소가 맵핑해놓은 주소와 다르면 뷰네임을 줘야하므로 ModelAndView를 써야함
	}
	
}
