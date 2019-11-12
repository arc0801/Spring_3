package com.arc.s3.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.arc.s3.model.board.NoticeVO;
import com.arc.s3.util.Pager2;
import com.arc.s3.util.RowMaker;

@Repository
public class NoticeDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper."; 
	
	public int noticeCount(Pager2 pager2) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"noticeCount", pager2);
	}
	
	public int noticeUpdate(NoticeVO noticeVO) throws Exception {
		return sqlSession.update(NAMESPACE+"noticeUpdate", noticeVO);
	}
	
	public List<NoticeVO> noticeList(Pager2 pager2) throws Exception {
		return sqlSession.selectList(NAMESPACE+"noticeList", pager2);
	}
	
	public NoticeVO noticeSelect(int num) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		return sqlSession.selectOne(NAMESPACE+"noticeSelect", map);
	}
	
	public int noticeDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE+"noticeDelete", num);
	}
	
	public int noticeInsert(NoticeVO noticeVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"noticeInsert", noticeVO);
	}
}
