package cn.leekoko.common.utils;

import java.io.IOException;

public class OutputMDUtilTest {
/*	
	*//**
	 * 输出md文件方法
	 * @throws IOException 
	 *//*
	@Test
	public void outPutTest(){
		MDUtil mdUtil = new MDUtil();
		FileReader fr = null;
		try {
			String sign = "#";
			mdUtil.textAppend("标题",sign);
//        	mdUtil.outPut("D:\\a.md");
        	File f = new File("D:\\a.md");//文件在src名为test1.txt中
            fr = new FileReader(f);//将文件读取到内容中
            Assert.assertNotNull(fr);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
        	Assert.fail("expect FileNotFoundException");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Assert.fail("expect IOExceptionException");
        }
	}
	
	*//**
	 * 测试文件输入
	 * @throws IOException 
	 *//*
	@Test
	public void inputTest() throws IOException{
		MDUtil mdUtil = new MDUtil();
		String path = "D:/github_place/LeeS/SourceCode/apache-tomcat-8.0.30/webapps/lees-manager-controller/LeesAttach/a.md";
		mdUtil.getFile(path);
		System.out.println(mdUtil.getContent());
//		Assert.assertEquals(mdUtil.getContent(),"test");
	}
	
	*//**
	 * 测试文件文本追加
	 * @throws IOException 
	 *//*
	@Test
	public void textAppendTest() throws IOException{
		MDUtil mdUtil = new MDUtil();
		String path = "D:\\b.md"; 
		mdUtil.getFile(path); 
		mdUtil.textAppend("追加的内容1","#");  
		Assert.assertEquals(mdUtil.getContent().replaceAll("\\s*", ""),"test#追加的内容1");
		mdUtil.textAppend("追加的内容2","D:");  
		mdUtil.textAppend("追加的内容3","###");  
//    	mdUtil.outPut("D:\\c.md");
	}
	*/

}