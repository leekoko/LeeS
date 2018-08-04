package cn.leekoko.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.leekoko.service.AttachmentService;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {
	
	@Autowired
	AttachmentService attachmentService;

	@RequestMapping(value="uploadFile")
    public String uploadFile(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
    	return attachmentService.uploadFile(request, response, path);
    }

}
