package com.arc.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.arc.s3.dao.board.QnaDAO;
import com.arc.s3.model.board.QnaVO;
import com.arc.s3.util.Pager;
import com.arc.s3.util.Pager2;
import com.arc.s3.util.RowMaker;

@Service
public class QnaService {
//Test
	@Inject
	private QnaDAO qnaDAO;
	
	public List<QnaVO> qnaList(Pager2 pager2) throws Exception {
		//DB 보내기 위해 rownum 계산
		pager2.makeRow();
		//int count = qnaDAO.qnaCount(); -> 여러 번 써야할 때
		pager2.makePage(qnaDAO.qnaCount(pager2));
		
		return qnaDAO.qnaList(pager2);
	}
	
	public int qnaInsert(QnaVO qnaVO) throws Exception {
		return qnaDAO.qnaInsert(qnaVO);
	}
}
