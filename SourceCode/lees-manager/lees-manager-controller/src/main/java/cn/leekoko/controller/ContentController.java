package cn.leekoko.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.leekoko.common.utils.MDUtil;

@Controller
@RequestMapping("/content")
public class ContentController {
	
	@RequestMapping("/exportMD")
	public void exportMD(String content,HttpServletResponse response){
		content = content.replace(",", "\r\n");
		try {
			MDUtil.outPut(content,response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 上传加载MD文件
	 * @param request
	 * @param response
	 */
	@RequestMapping("/uploadMD")
	public void uploadMD(HttpServletRequest request, HttpServletResponse response,Model model){
		attachmentController attachmentController = new attachmentController();
		try {
			String path = attachmentController.uploadFile(request, response);
			List<String> list = MDUtil.getFile(path);
			model.addAttribute("list", list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
