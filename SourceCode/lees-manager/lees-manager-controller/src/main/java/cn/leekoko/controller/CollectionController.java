package cn.leekoko.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.leekoko.pojo.Collectioncontent;
import cn.leekoko.pojo.CollectioncontentExample;
import cn.leekoko.pojo.CollectioncontentExample.Criteria;
import cn.leekoko.pojo.Collectiontype;
import cn.leekoko.service.CollectionTypeService;
import cn.leekoko.service.CollectioncontentService;


@Controller
@RequestMapping("/collection")
public class CollectionController {
	
	@Autowired
	CollectionTypeService collectionTypeService;
	@Autowired
	CollectioncontentService collectioncontentService;
	@Autowired
	AttachmentController attachmentController;
	
	@RequestMapping("/collectionType")
	@ResponseBody
	public List<Collectiontype> getBigtypeList() {
		List<Collectiontype> typeList = collectionTypeService.getTypeList();
		return typeList;
	}
	
    @ResponseBody
    @RequestMapping(value = "/getContentList")
	public List<Collectioncontent> getContentList(@RequestParam(value="parentId")int parentId) {
		List<Collectioncontent> list = collectioncontentService.getByList(parentId);
		return list;
	}

	/**
	 * 上传加载MD文件
	 * @param request
	 * @param response
	 */
	@RequestMapping("/uploadImg")
	public void uploadMD(HttpServletRequest request, HttpServletResponse response,Model model,@RequestParam String id){
		try {
			String imgPath = "//images";
			Collectioncontent collectioncontent = new Collectioncontent();
			String imgUrl = attachmentController.uploadFile(request, response, imgPath);
			String fileName = imgUrl.substring(imgUrl.lastIndexOf("\\"));   //截取最后一个目录
			collectioncontent.setImgurl("images"+fileName);
			collectioncontent.setId(id);
			collectioncontentService.insertSelective(collectioncontent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Object save(HttpServletRequest request, HttpServletResponse response,String id,String title,String pageUrl,String intro,String typeId){
		boolean result = false;
		CollectioncontentExample example = new CollectioncontentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		Collectioncontent collectioncontent = new Collectioncontent();
		collectioncontent.setTitle(title);
		collectioncontent.setPageurl(pageUrl);
		collectioncontent.setIntro(intro);
		collectioncontent.setParentid(Integer.parseInt(typeId));
		collectioncontentService.updateByExampleSelective(collectioncontent,example);
		result = true;
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", result);
		return map;
	}

	@RequestMapping("/addType")
	@ResponseBody
	public Object addType(String typeName){
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		boolean result = false;
		Collectiontype collectiontype = new Collectiontype();
		collectiontype.setTypename(typeName);
		int resultNum = collectionTypeService.insertSelective(collectiontype);
		if(resultNum > 0){
			result = true;
		}
		map.put("result", result);
		return map;
	}
	/**
	 * 更新点击时间
	 * @param id
	 */
	@RequestMapping("/updateClickDate")
	public void updateClickDate(String id){
		CollectioncontentExample example = new CollectioncontentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		Collectioncontent collectioncontent = new Collectioncontent();
		collectioncontent.setClickdate(new Date());
		collectioncontentService.updateByExampleSelective(collectioncontent,example);
	}
}
