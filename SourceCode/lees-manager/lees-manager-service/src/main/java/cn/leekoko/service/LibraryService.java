package cn.leekoko.service;

import java.util.List;

import cn.leekoko.pojo.Library;

public interface LibraryService {
	 int insert(Library library);
	 List<Library> getSeatList(String letOutType);
}
