package cn.leekoko.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
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
	
	
}
