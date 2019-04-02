package cn.leekoko.controller;

import cn.leekoko.pojo.Collectiontype;
import cn.leekoko.pojo.Library;
import cn.leekoko.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class PageController {
	
	@Autowired
	private OnlinecontentService onlinecontentService;
	@Autowired
	private CollectionTypeService collectionTypeService;
	@Autowired
	private LibraryService libraryService;
	@Autowired
	private TemplateService templateService;
	@Autowired
	private TemplateFlowService templateFlowService;

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

	/**
	 * 跳转到模板生成页面
	 * @return
	 */
	@RequestMapping("/modelPage")
	public String modelPage(){
		return "modelPage";
    }
	/**
	 * 跳转到模板选择页面
	 * @return
	 */
	@RequestMapping("/modelChosePage")
	public String modelChosePage(Model model){
		model.addAttribute("templateList",templateService.getList());
		return "modelChosePage";
	}
	/**
	 * 跳转到流程模板选择页面
	 * @return
	 */
	@RequestMapping("/flowChosePage")
	public String flowChosePage(Model model){
		model.addAttribute("templateFlowList", templateFlowService.getList());
		return "modelFlowChosePage";
	}



}
