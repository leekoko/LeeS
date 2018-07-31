package cn.leekoko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.leekoko.service.OnlinecontentService;

@Controller
public class PageController {
	
	@Autowired
	private OnlinecontentService onlinecontentService;
	
	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex(Model model){
		List<String> list = onlinecontentService.getContentList();
		model.addAttribute("list", list);
		return "index";
	}
}
