package cn.leekoko.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.leekoko.pojo.Collectiontype;
import cn.leekoko.service.CollectionTypeService;
import cn.leekoko.service.OnlinecontentService;

@Controller
public class PageController {
	
	@Autowired
	private OnlinecontentService onlinecontentService;
	@Autowired
	private CollectionTypeService collectionTypeService;
	
	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex(Model model){
		return "index";
	}
	/**
	 * 打开DB笔记页面
	 */
	@RequestMapping("/contentDB")
	public String showContentDB(Model model){
		List<String> list = onlinecontentService.getContentList();
		model.addAttribute("list", list);
		return "contentDB";
	}
	/**
	 * 打开收藏页面
	 */
	@RequestMapping("/collection")
	public String showCollection(Model model){
		List<Collectiontype> typeList = collectionTypeService.getTypeList();
		model.addAttribute("typeList", typeList);
		model.addAttribute("uuid", UUID.randomUUID().toString());
		return "collection";
	}
}
