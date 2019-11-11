package com.arc.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.arc.s3.TestAbstractCase;
import com.arc.s3.model.board.NoticeVO;


public class NoticeDAOTest extends TestAbstractCase{

	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void noticeCountTest() throws Exception {
		int count = noticeDAO.noticeCount();
		assertEquals(102, count);
	}
	
	//@Test
	public void checkDAO() throws Exception {
		assertNotNull(noticeDAO);
	}
	
	//@Test
	public void noticeInsertTest() throws Exception {
		for(int i=0;i<120;i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setTitle("t"+i);
			noticeVO.setWriter("w"+i);
			noticeVO.setContents("c"+i);
			
			int result = noticeDAO.noticeInsert(noticeVO);
		}
		//assertEquals(1, result);
	}
	
	//@Test
	public void noticeDeleteTest() throws Exception {
		int result = noticeDAO.noticeDelete(6);
		assertEquals(1, result);
	}
	
	//@Test
	public void noticeSelect() throws Exception {
		NoticeVO noticeVO = noticeDAO.noticeSelect(5);
		assertNotNull(noticeVO);
	}
	
	//@Test
	public void noticeList() throws Exception {
		//List<NoticeVO> list = noticeDAO.noticeList();
		//assertNotEquals(0, list.size());
	}
	
	//@Test
	public void noticeUpdate() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("t3");
		noticeVO.setContents("c3");
		noticeVO.setNum(5);
		
		int result = noticeDAO.noticeUpdate(noticeVO);
		assertEquals(1, result);
	}
}
