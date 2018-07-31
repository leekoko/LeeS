import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;


public class Test {

	@org.junit.Test
	public void test() {
		@SuppressWarnings("restriction")
		String type = new MimetypesFileTypeMap().getContentType("D:\\a.md");
        //根据文件名获取 MIME 类型
        System.out.println(type);
	}
	
	@org.junit.Test
	public void tempTest(){
		String str = "D：1111,D：2222,D：3333";
		str = str.replace(",", "\r\n");
		System.out.println(str);
	}
	
	@org.junit.Test
	public void TimeTest() throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formatter.format(new Date()));
		
	}


}
