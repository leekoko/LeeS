package cn.leekoko.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
/**
 * 操作MD文件工具类
 * @author liyb
 * @version 2018年7月27日  上午11:00:51
 */
public class MDUtil {
	

	private static final int SIZE = 4096;
	
	private static StringBuilder content = new StringBuilder();
	
	public String getContent() {
		return content.toString();
	}
	
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
	public void getFile(String path) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(path);
		if(!file.exists()){
			throw new RuntimeException("要读取的文件不存在");
		}
		
		FileInputStream fis = new FileInputStream(file);
		int len = 0;
		byte[] buf = new byte[SIZE];
		while((len=fis.read(buf))!=-1){
			this.textAppend(new String(buf,0,len),"");
		}
		//关资源
		fis.close();
	}
	
	public static void text(String str){
		textAppend(str, null);
	}
	
	/**
	 * 文本追加内容
	 * 20180708
	 * @param str
	 * @param sign   前缀标记
	 * @throws IOException
	 */
	public static void textAppend(String str,String sign){
		if(StringUtils.isNotEmpty(sign)){
			String signStr = "\r\n"+sign+" ";
			content.append(signStr + str);
		}else{
			content.append(str);
		}
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
