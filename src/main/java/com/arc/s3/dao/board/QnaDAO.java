package com.arc.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.arc.s3.model.board.QnaVO;
import com.arc.s3.util.Pager2;
import com.arc.s3.util.RowMaker;

@Repository
public class QnaDAO {
//Test
	@Inject
	private SqlSession sqlSession; //root-context.xml //Test
	
	private static final String NAMESPACE = "qnaMapper.";
	//계속 qnaMapper에서 가져올거니까 멤버변수로 선언해준다.
	
	public int qnaReplyUpdate(QnaVO qnaVO) throws Exception {
		return sqlSession.update(NAMESPACE+"qnaReplyUpdate", qnaVO);
	}
	
	public int qnaReply(QnaVO qnaVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"qnaReply", qnaVO);
	}
	
	public QnaVO qnaSelect(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"qnaSelect", num);
	}
	
	public List<QnaVO> qnaList(Pager2 pager2) throws Exception {
		return sqlSession.selectList(NAMESPACE+"qnaList", pager2);
	}
	
	public int qnaWrite(QnaVO qnaVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"qnaWrite", qnaVO);
	}
	
	public int qnaCount(Pager2 pager2) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"qnaCount", pager2);
	}
}
