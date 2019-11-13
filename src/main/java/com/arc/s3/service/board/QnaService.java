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
	//여기까지는 qnaVO에 부모글의 글번호가 들어있다
	public int qnaReply(QnaVO qnaVO) throws Exception {
		//부모의 정보
		QnaVO parent = qnaDAO.qnaSelect(qnaVO.getNum());
		int result = qnaDAO.qnaReplyUpdate(parent);
		
		qnaVO.setRef(parent.getRef());
		qnaVO.setStep(parent.getStep() +1);
		qnaVO.setDepth(parent.getDepth() +1);
		
		result = qnaDAO.qnaReply(qnaVO);
		
		return result;
	}
	
	public QnaVO qnaSelect(int num) throws Exception {
		return qnaDAO.qnaSelect(num);
	}
	
	public int qnaWrite(QnaVO qnaVO) throws Exception {
		return qnaDAO.qnaWrite(qnaVO);
	}
	
	public List<QnaVO> qnaList(Pager2 pager2) throws Exception {
		//DB 보내기 위해 rownum 계산
		pager2.makeRow();
		//int count = qnaDAO.qnaCount(); -> 여러 번 써야할 때
		pager2.makePage(qnaDAO.qnaCount(pager2));
		
		return qnaDAO.qnaList(pager2);
	}
}
