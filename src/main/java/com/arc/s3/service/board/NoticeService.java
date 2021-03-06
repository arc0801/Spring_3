package com.arc.s3.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.arc.s3.dao.board.NoticeDAO;
import com.arc.s3.model.board.NoticeVO;
import com.arc.s3.util.Pager;
import com.arc.s3.util.Pager2;
import com.arc.s3.util.RowMaker;

@Service
public class NoticeService {

	@Inject
	private NoticeDAO noticeDAO;
	
	public List<NoticeVO> noticeList(Pager2 pager2) throws Exception {
		pager2.makeRow();
		pager2.makePage(noticeDAO.noticeCount(pager2));
		
		return noticeDAO.noticeList(pager2);
	}
	
	public NoticeVO noticeSelect(int num) throws Exception {
		return noticeDAO.noticeSelect(num);
	}
	
	public int noticeUpdate(NoticeVO noticeVO) throws Exception {
		return noticeDAO.noticeUpdate(noticeVO);
	}
	
	public int noticeDelete(int num) throws Exception {
		return noticeDAO.noticeDelete(num);
	}
	
	public int noticeInsert(NoticeVO noticeVO) throws Exception {
		return noticeDAO.noticeInsert(noticeVO);
	}
}
