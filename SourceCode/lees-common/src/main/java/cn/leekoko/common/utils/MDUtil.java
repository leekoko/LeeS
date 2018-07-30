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
 * ����MD�ļ�������
 * @author liyb
 * @version 2018��7��27��  ����11:00:51
 */
public class MDUtil {
	

	private static final int SIZE = 4096;
	
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
	public static List<String> getFile(String path){
		// TODO Auto-generated method stub
		File file = new File(path);
		List<String> list = new ArrayList<String>();
		if(!file.exists()){
			throw new RuntimeException("Ҫ��ȡ���ļ�������");
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
				//content.append(new String(buf,0,len,"utf-8"));    //����������������
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
		//����Դ
		return list;
	}
	/**
	 * �ж��Ƿ�ӻس�
	 * @param substring
	 * @return
	 */
	private static boolean addEnter(String str) {
		if(str.equals("D��") || str.equals("Z��") || str.equals("M��") ||  str.equals("# ") ||  str.equals("##")){
			return true;
		}
		return false;
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
