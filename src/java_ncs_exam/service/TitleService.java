package java_ncs_exam.service;

import java.util.List;

import java_ncs_exam.dao.TitleDao;
import java_ncs_exam.dto.Title;
import java_ncs_exam.impl.TitleDaoImpl;

public class TitleService {
	private TitleDao titleDao = TitleDaoImpl.getInstance();
	
	
	public List<Title> showTitle(){
		return titleDao.selectTitleByAll();
	}
	public void addTitle(Title title) {
		titleDao.insertTitle(title);
	}
	public void removeTitle(Title title) {
		titleDao.deleteTitle(title.gettNo());
	}
	public void modifyTitle(Title title) {
		titleDao.updateTitle(title);
	}

}
