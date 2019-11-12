package com.arc.s3;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.arc.s3.model.board.QnaVO;
import com.arc.s3.service.board.QnaService;
import com.arc.s3.util.Pager2;

public class QnaServiceTest extends TestAbstractCase { //상속 받아랍!!!!!!!!!!!!!!!!!!!

	@Inject
	private QnaService qnaService;
	
	@Test
	public void qnaListTest() throws Exception {
		Pager2 pager2 = new Pager2();
		pager2.makePage(78);
		List<QnaVO> ar = qnaService.qnaList(pager2);
		
		//assertNotEquals(0, ar.size());
		//assertEquals(1, (int)pager2.getStartRow());
		//assertEquals(10, (int)pager2.getLastRow());
		
		assertEquals(1, (int)pager2.getStartNum());
		assertEquals(5, (int)pager2.getLastNum());
	}

}
