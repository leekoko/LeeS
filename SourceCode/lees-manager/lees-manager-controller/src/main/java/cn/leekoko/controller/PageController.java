package cn.leekoko.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.leekoko.pojo.Collectiontype;
import cn.leekoko.pojo.Library;
import cn.leekoko.service.CollectionTypeService;
import cn.leekoko.service.LibraryService;
import cn.leekoko.service.OnlinecontentService;

@Controller
public class PageController {
	
	@Autowired
	private OnlinecontentService onlinecontentService;
	@Autowired
	private CollectionTypeService collectionTypeService;
	@Autowired
	private LibraryService libraryService;
	
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
	 * 打开图书馆页面
	 */
	@RequestMapping("/library")
	public String showLibrary(Model model){
		//A模式
		String letOutType = "1";
		List<Library> seatListA = libraryService.getSeatList(letOutType);
		model.addAttribute("seatListA", seatListA);
		//B模式
		letOutType = "2";
		List<Library> seatListB = libraryService.getSeatList(letOutType);
		model.addAttribute("seatListB", seatListB);
		return "library";
	}
	/**
	 * 打开图书馆选择首页
	 */
	@RequestMapping("/type")
	public String libraryChoseType(Model model){
		return "libraryChoseType";
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
	@RequestMapping("/video")
	public String video(Model model){
		return "video";
	}



}
