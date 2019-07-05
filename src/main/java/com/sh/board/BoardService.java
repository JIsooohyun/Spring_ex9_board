package com.sh.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.sh.util.PagerMaker;

public interface BoardService {
		//글 리스트
		public List<BoardDTO> getList(PagerMaker pagerMaker)throws Exception;
		
		//글 한개
		public BoardDTO getSelect(int num)throws Exception;
		
		//글 삭제
		public int setDelete(int num)throws Exception;
		
		//글 수정
		public int setUpdate(BoardDTO boardDTO)throws Exception;
		
		//글 등록
		public int setWrite(BoardDTO boardDTO, List<MultipartFile> files, HttpSession session)throws Exception;
}
