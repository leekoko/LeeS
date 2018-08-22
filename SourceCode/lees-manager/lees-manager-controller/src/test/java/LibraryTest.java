import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import cn.leekoko.pojo.Library;

public class LibraryTest {

	@Test
	public void test() throws ParseException {
		String time = "2018-08-05 23:17:10";
		Library library = new Library();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		library.setLetouttimea(formatter.parse(time));
	}

}
