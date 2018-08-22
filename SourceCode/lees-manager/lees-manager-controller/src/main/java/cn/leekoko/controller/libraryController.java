package cn.leekoko.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.leekoko.pojo.Library;
import cn.leekoko.service.LibraryService;

@Controller
@RequestMapping("/library")
public class libraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@RequestMapping("letOutSeat")
	@ResponseBody
	public Object letOutSeat(HttpServletRequest request,Model model,String seatNum,String letOutType,String letOutTime) throws ParseException{
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		boolean result =  false;
		Library library = new Library();
		library.setSeatnum(seatNum);
		library.setLetouttype(letOutType);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if("1".equals(letOutType)){
			library.setLetouttimea(formatter.parse(letOutTime));
		}else if("2".equals(letOutType)){
			library.setLetouttimeb(formatter.parse(letOutTime));
		}else{
			return null;
		}
		int num = libraryService.insert(library);
		if(num > 0){
			result = true;
		}
		map.put("result", result);
		return map;
	}
	
	

}
