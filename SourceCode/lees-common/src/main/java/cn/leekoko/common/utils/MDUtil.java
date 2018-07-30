package cn.leekoko.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
/**
 * 操作MD文件工具类
 * @author liyb
 * @version 2018年7月27日  上午11:00:51
 */
public class MDUtil {
	

	private static final int SIZE = 4096;
	
	/**
	 * 输出md文件
	 * 20180708
	 * @throws IOException
	 */
	public static void outPut(String str,HttpServletResponse response) throws IOException{
		//content-type    application/octet-stream
		String fileName = Date2FileName("yyyyMMddhhssmm","md");
		String contentDisposition = "attachment;filename=" + fileName;
        // 设置头，处理乱码问题
        response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Content-Disposition",contentDisposition);
        // 获取绑定了客户端的流
        ServletOutputStream output = response.getOutputStream();
        output.write(str.getBytes("UTF-8"));
        output.close();
	}
	
	/**
	 * 获取md文件内容
	 * 20180708
	 * @param path
	 * @throws IOException 
	 */
	public static List<String> getFile(String path){
		// TODO Auto-generated method stub
		File file = new File(path);
		List<String> list = new ArrayList<String>();
		if(!file.exists()){
			throw new RuntimeException("要读取的文件不存在");
		}
		StringBuffer content = new StringBuffer();
		try {
//			fis = new FileInputStream(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			int len = 0;
			byte[] buf = new byte[SIZE];
//			while((len=fis.read(buf))!=-1){
			String s;
			while((s = in.readLine()) != null){
				//content.append(new String(buf,0,len,"utf-8"));    //处理中文乱码问题
				if(s.trim().length() > 0){
					if(addEnter(s.substring(0,2))){
						list.add("/n/r"+s);
					}else{
						list.add(s);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
		//关资源
		return list;
	}
	/**
	 * 判断是否加回车
	 * @param substring
	 * @return
	 */
	private static boolean addEnter(String str) {
		if(str.equals("D：") || str.equals("Z：") || str.equals("M：") ||  str.equals("# ") ||  str.equals("##")){
			return true;
		}
		return false;
	}

	/**
	 * 获取文件名
	 * @param nameFormat
	 * @param fileType
	 * @return
	 */
	public static String Date2FileName(String nameFormat, String fileType) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(nameFormat);
		String fileName = dateFormat.format(date) + "." + fileType;
		return fileName;
	}
	
	
}
