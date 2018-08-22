import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;

public class SortTest {
	@Test
	public void listSortTest() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "°¡");
		list.add(map);
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "´Ó");
		list.add(map1);
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "µ½");
		list.add(map2);
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "°É");
		list.add(map3);
		//listSort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("name"));
		}
	}

	public void listSort(List<Map<String, Object>> resultList) {
		Collections.sort(resultList, new Comparator<Map<String, Object>>() {
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				String name1 = o1.get("name").toString();
				String name2 = o2.get("name").toString();
				Collator instance = Collator.getInstance(Locale.CHINA);
				return instance.compare(name1, name2);
			}
		});
	}
}
