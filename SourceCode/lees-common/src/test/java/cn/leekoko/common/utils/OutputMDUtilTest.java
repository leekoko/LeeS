package cn.leekoko.common.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class OutputMDUtilTest {
	
	/**
	 * ���md�ļ�����
	 * @throws IOException 
	 */
	@Test
	public void outPutTest(){
		MDUtil mdUtil = new MDUtil();
		FileReader fr = null;
		try {
			String sign = "#";
			mdUtil.textAppend("����",sign);
        	mdUtil.outPut("D:\\a.md");
        	File f = new File("D:\\a.md");//�ļ���src��Ϊtest1.txt��
            fr = new FileReader(f);//���ļ���ȡ��������
            Assert.assertNotNull(fr);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
        	Assert.fail("expect FileNotFoundException");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Assert.fail("expect IOExceptionException");
        }
	}
	
	/**
	 * �����ļ�����
	 * @throws IOException 
	 */
	@Test
	public void inputTest() throws IOException{
		MDUtil mdUtil = new MDUtil();
		String path = "D:\\b.md";
		mdUtil.getFile(path);
		Assert.assertEquals(mdUtil.getContent(),"test");
	}
	
	/**
	 * �����ļ��ı�׷��
	 * @throws IOException 
	 */
	@Test
	public void textAppendTest() throws IOException{
		MDUtil mdUtil = new MDUtil();
		String path = "D:\\b.md"; 
		mdUtil.getFile(path); 
		String sign = "#";
		mdUtil.textAppend("׷�ӵ�����1",sign);  
		String signStr = "\r\n"+sign+" ";
		Assert.assertEquals(mdUtil.getContent(),"test"+signStr+"׷�ӵ�����1");
		sign = "D:";
		mdUtil.textAppend("׷�ӵ�����2",sign);  
		sign = "###";
		mdUtil.textAppend("׷�ӵ�����3",sign);  
    	mdUtil.outPut("D:\\c.md");
	}
	

}
