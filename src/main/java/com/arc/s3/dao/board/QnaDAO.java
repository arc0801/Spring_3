package com.arc.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.arc.s3.model.board.QnaVO;
import com.arc.s3.util.RowMaker;

@Repository
public class QnaDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "qnaMapper.";
	
	public List<QnaVO> qnaList(RowMaker rowMaker) throws Exception {
		return sqlSession.selectList(NAMESPACE+"qnaList", rowMaker);
	}
	
	public int qnaInsert(QnaVO qnaVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"qnaInsert", qnaVO);
	}
	
	public int qnaCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"qnaCount");
	}
}
