 package com.arc.s3;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.arc.s3.dao.board.QnaDAO;
import com.arc.s3.model.board.QnaVO;

public class QnaDAOTest extends TestAbstractCase{ //상속 받아랍!!!!!!!!!!!!!!!!!!!

	@Inject
	private QnaDAO qnaDAO;
	
	@Test
	public void test() {
		this.qnaDAOTest();
	} //annotation 한 번만 쓰면 됨
	
	private void qnaListTest() throws Exception {
		//List<QnaVO> ar = qnaDAO.qnaList(rowMaker);
		// assertNotEquals(0, ar.size());
	}
	
	private void qnaDAOTest() {
		assertNotNull(qnaDAO);
	}
	
	//@Test
	public void qnaList() throws Exception {
		//List<QnaVO> list = qnaDAO.qnaList();
		//assertNotEquals(0, list.size());
	}

	//@Test
	public void qnaInsert() throws Exception {
		int result = 0;
		
		for(int i=0;i<100;i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setTitle("t"+i);
			qnaVO.setWriter("w"+i);
			qnaVO.setContents("c"+i);
			
			result = qnaDAO.qnaInsert(qnaVO);
		}
		assertEquals(1, result);
	}
}
