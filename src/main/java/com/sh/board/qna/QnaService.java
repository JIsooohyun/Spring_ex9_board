package com.sh.board.qna;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sh.board.BoardDTO;
import com.sh.board.BoardService;
import com.sh.file.FileDAO;
import com.sh.file.FileDTO;
import com.sh.util.FileSaver;
import com.sh.util.PagerMaker;

@Service
public class QnaService implements BoardService {

	@Inject
	private QnaDAO qnaDAO;
	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;
	
	
	@Override
	public List<BoardDTO> getList(PagerMaker pagerMaker) throws Exception {
		//1.startRow, lastRow
		pagerMaker.makeRow();
		List<BoardDTO> list =  qnaDAO.getList(pagerMaker);
		//2.pageing, totalCount
		int totalCount = qnaDAO.getTotalCount(pagerMaker);
		pagerMaker.makePage(totalCount);
			
		return list;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getSelect(num);
	}

	@Override
	public int setDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		//qna Insert
		int result = qnaDAO.setWrite(boardDTO);
		String realPath = session.getServletContext().getRealPath("/resources/qna");
		//files Insert
		
		//fileDTO에서 num은 어디서 받아오냐  num=boardDTO.getNum();
		//oname = multipartFile.getOrginalName();
		//fname = fileSaver.savefile(realpath, multpartFile)
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		for(MultipartFile multipartFile : multipartFiles) {
			String fname = fileSaver.fileSaver(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			files.add(fileDTO);
		}
		System.out.println(files.size());
		fileDAO.setWrite(files);
		
		return result;
	}
	
	//reply
	public int setReply(QnaDTO qnaDTO)throws Exception{
		//1. 사전작업
		int result = qnaDAO.setReplyUpdate(qnaDTO);
		//2.insert 
		result = qnaDAO.setReply(qnaDTO);
		return result;
		
	}

}
