package com.kh.mvc04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.kh.mvc04.validate.FileValidator;
import com.kh.mvc04.validate.UploadFile;

@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping("/form")
	public String getUploadForm() {
		return "uploadform";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		
		fileValidator.validate(uploadFile, result);
		if(result.hasErrors()) {	// Validator에 파일을 보내 놓는데 거기서 문제가 생기면(error) 이곳으로 되돌린다. 이 되돌린 값은 form:errors에 있는곳으로 간다 !!
			return "uploadform";
		}
		
		MultipartFile file = uploadFile.getFile();
		// 현 filename이 비어있기 때문에 실제파일이름(getOriginalFilename)을 넣어준다.
		String filename = file.getOriginalFilename();
		
		UploadFile fileobj = new UploadFile();
		fileobj.setFilename(filename);
		fileobj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream();
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
/*
			절대 경로 : c:\...
			상대 경로 : 내 폴더 위치 기준으로 무언가를 찾는다.
			/ : 최상위 
			./ : 현재 폴더 
			../ : 상위 
			../../ : 상위의 상위
*/
			
			System.out.println("업로드 될 실제 경로 : " + path);
			
			File storage = new File(path);
			if(!storage.exists()) {	// 경로가 없으면 폴더를 만든다
				storage.mkdirs();
			}
			
			File newfile = new File(path + "/" + filename);
			
			if(!newfile.exists()) {
				newfile.createNewFile();
				// 파일이 없으면 빈 파일 생성
			}
			
			outputStream = new FileOutputStream(newfile);
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			
			while((read=inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}
			
			//byte[0] ~ read
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileobj", fileobj);
		
		return "uploadfile";
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDown(HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {
		
		String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		File file = new File(path + "/" + filename);
	
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		String fn = new String(file.getName().getBytes(), "8859_1");
		
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		response.setContentLength(bytes.length);		
		response.setContentType("image/jpeg");			//img만 다운됨
		// tomcat web.xml 확인
		
		return bytes;
	}
}






