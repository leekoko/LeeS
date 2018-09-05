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

	/**
	 * 选择列页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectColumnPage")
	public String selectColumn(Model model){
		String sql = "select * from collectioncontent";
		String id = "tempid";
		ArrayList<String> list = getColumnName(sql);
		model.addAttribute("list", list);
		model.addAttribute("sql",sql);
		model.addAttribute("id",id);
		return "selectColumnPage";
	}

	/**
	 * 获取该sql列名
	 * @param sql
	 * @return
	 */
	public ArrayList<String> getColumnName(String sql){
		ArrayList<String> list = new ArrayList<String>();
		//声明Connection对象
		Connection con;
		//驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/lees";
		//MySQL配置时的用户名
		String user = "root";
		//MySQL配置时的密码
		String password = "123456";
		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(driver);
			//1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			//2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
			//3.ResultSet类，用来存放获取的结果集！！
			ResultSet rs = statement.executeQuery(sql);
			String job = null;
			String id = null;
			ResultSetMetaData rsmd = rs.getMetaData();
			//ResultSetMetaData是用于分析结果集的元数据接口
			int  columnCount = rsmd.getColumnCount();
			while(rs.next()){
				for (int i = 0 ; i < columnCount ; i++ ) {
					list.add(rsmd.getColumnName(i+1));
				}
				break;
			}
			rs.close();
			con.close();
		} catch(ClassNotFoundException e) {
			//数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch(SQLException e) {
			//数据库连接失败异常处理
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			System.out.println("success get！！");
		}
		return list;
	}


}
