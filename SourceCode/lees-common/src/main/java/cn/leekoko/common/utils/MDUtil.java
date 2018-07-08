package cn.leekoko.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;

public class MDUtil {
	

	private static final int SIZE = 4096;
	//内容
	private StringBuilder content = new StringBuilder();
	
	public String getContent() {
		return content.toString();
	}
	
	/**
	 * 输出md文件
	 * 20180708
	 * @throws IOException
	 */
	public void outPut(String path) throws IOException {
		// TODO Auto-generated method stub
        // 1：利用File类找到要操作的对象
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        //2：准备输出流
        Writer out = new FileWriter(file);
        out.write(content.toString());
        out.close();
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
	
	/**
	 * 文本追加内容
	 * 20180708
	 * @param str
	 * @param sign   前缀标记
	 * @throws IOException
	 */
	public void textAppend(String str,String sign) throws IOException {
		if(StringUtils.isNotEmpty(sign)){
			String signStr = "\r\n"+sign+" ";
			content.append(signStr + str);
		}
		content.append(str);
	}
	
	
	
	
}
