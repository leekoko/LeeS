package cn.leekoko.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.leekoko.common.utils.MDUtil;
import cn.leekoko.pojo.Onlinecontent;
import cn.leekoko.service.OnlinecontentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	OnlinecontentService onlinecontentService;
	
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
			//将数据存入到数据库中
			Onlinecontent onlinecontent = new Onlinecontent();
			for (int i = list.size()-1; i >= 0 ; i--) {
				onlinecontent.setContent(list.get(i));
				onlinecontentService.insertSelective(onlinecontent);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("delete")
	public void delete(HttpServletResponse response){
		onlinecontentService.delete();
	}	
	
	@RequestMapping("insert")
	public void insert(String content){
		Onlinecontent onlinecontent = new Onlinecontent();
		onlinecontent.setContent(content);
		onlinecontent.setCreatetime(new Date());
		onlinecontentService.insertSelective(onlinecontent);
	}	
	
}
