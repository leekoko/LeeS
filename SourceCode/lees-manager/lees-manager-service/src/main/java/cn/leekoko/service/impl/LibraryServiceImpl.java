package cn.leekoko.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.leekoko.mapper.LibraryMapper;
import cn.leekoko.pojo.Library;
import cn.leekoko.pojo.LibraryExample;
import cn.leekoko.pojo.LibraryExample.Criteria;
import cn.leekoko.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryMapper libraryMapper;
	
	public int insert(Library library) {
		return libraryMapper.insertSelective(library);
	}
	
	public List<Library> getSeatList(String letOutType) {
		LibraryExample example = new LibraryExample();
		Criteria criteria = example.createCriteria();
		criteria.andLetouttypeEqualTo(letOutType);
		return libraryMapper.selectByExample(example);
	}

}
