package com.sh.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sh.board.BoardDAO;
import com.sh.board.BoardDTO;
import com.sh.util.PagerMaker;

@Repository
public class QnaDAO implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="QnaMapper.";
	
	//답글
	public int setReply(QnaDTO qnaDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setReply", qnaDTO);
	}
	
	//답글 사전작업
	public int setReplyUpdate(QnaDTO qnaDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setReplyUpdate", qnaDTO);
	}
	
	
	@Override
	public List<BoardDTO> getList(PagerMaker pagerMaker) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getList", pagerMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getSelect", num);
	}

	@Override
	public int setDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"setDelete", num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setWrite", boardDTO);
	}

	@Override
	public int getTotalCount(PagerMaker pageMaker) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getCount", pageMaker);
	}

}
