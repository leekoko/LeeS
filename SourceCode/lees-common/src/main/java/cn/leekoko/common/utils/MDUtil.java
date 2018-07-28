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
 * ����MD�ļ�������
 * @author liyb
 * @version 2018��7��27��  ����11:00:51
 */
public class MDUtil {
	

	private static final int SIZE = 4096;
	
	private static StringBuilder content = new StringBuilder();
	
	public String getContent() {
		return content.toString();
	}
	
	/**
	 * ���md�ļ�
	 * 20180708
	 * @throws IOException
	 */
	public static void outPut(String str,HttpServletResponse response) throws IOException{
		//content-type    application/octet-stream
		String fileName = Date2FileName("yyyyMMddhhssmm","md");
		String contentDisposition = "attachment;filename=" + fileName;
        // ����ͷ��������������
        response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Content-Disposition",contentDisposition);
        // ��ȡ���˿ͻ��˵���
        ServletOutputStream output = response.getOutputStream();
        output.write(str.getBytes("UTF-8"));
        output.close();
	}
	
	/**
	 * ��ȡmd�ļ�����
	 * 20180708
	 * @param path
	 * @throws IOException 
	 */
	public void getFile(String path) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(path);
		if(!file.exists()){
			throw new RuntimeException("Ҫ��ȡ���ļ�������");
		}
		
		FileInputStream fis = new FileInputStream(file);
		int len = 0;
		byte[] buf = new byte[SIZE];
		while((len=fis.read(buf))!=-1){
			this.textAppend(new String(buf,0,len),"");
		}
		//����Դ
		fis.close();
	}
	
	public static void text(String str){
		textAppend(str, null);
	}
	
	/**
	 * �ı�׷������
	 * 20180708
	 * @param str
	 * @param sign   ǰ׺���
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
	 * ��ȡ�ļ���
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
