package com.lolcomm.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.lolcomm.domain.UserQuizVO;
import com.lolcomm.service.UserQuizService;
import com.lolcomm.utils.UploadFileUtils;


@Controller
@RequestMapping("/userquiz/*")
public class UserQuizController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserQuizController.class);
	
	@Inject
	private UserQuizService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registGET() throws Exception {
		
		logger.info("@@@ /regist 주소 호출");
		logger.info("@@@ 컨트롤러 registGET() 호출");
		logger.info("./userquiz/regist.jsp 페이지 호출");
		
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(UserQuizVO vo, MultipartFile file) throws Exception {
		
		logger.info("### /regist 주소 호출");
		logger.info("### /컨트롤러 reigstPOST() 호출");
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 

		vo.setOri_file(file.getOriginalFilename());
		vo.setSave_file(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		
		System.out.println("유저퀴즈등록정보" + vo);
		
		service.regist(vo);
		
		System.out.println("@@@ 컨트롤러 : 유저퀴즈 등록 완료!");
		
		return "redirect:/";
	}

}
