package com.sh.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="FileMapper.";
	
	public int setWrite(List<FileDTO> files)throws Exception{
		return sqlSession.insert(NAMESPACE+"setWrite", files);
	}
	
	public int setDelete(int num)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", num);
	}
	
	public FileDTO getSelect(int fnum)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", fnum);
	}
	
}
