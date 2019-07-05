package com.sh.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	//1. OutPutStream연결
	public String fileSaver(String realPath, MultipartFile multipartFile)throws Exception{
		File file = new File(realPath);
		
		if(!file.exists()) {
			file.mkdir();
		}
		
		//2.저장팔 파일명 생성
		//UUID클래스를 사용
		String fileSystemName = UUID.randomUUID().toString();
		String orginalName = multipartFile.getOriginalFilename();
		if(!orginalName.equals("")) {
			orginalName = orginalName.substring(orginalName.lastIndexOf("."));
			fileSystemName = fileSystemName+orginalName;
			//자바에서 제공하는 output을 이용
			file = new File(realPath, fileSystemName);
			FileOutputStream fs = new FileOutputStream(file);
			fs.write(multipartFile.getBytes());
		}else {
			fileSystemName="";
		}
		
		return fileSystemName;
	}
}
