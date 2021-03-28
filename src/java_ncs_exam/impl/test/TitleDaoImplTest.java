package java_ncs_exam.impl.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java_ncs_exam.dao.TitleDao;
import java_ncs_exam.dto.Title;
import java_ncs_exam.impl.TitleDaoImpl;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoImplTest {

	private static TitleDao dao = TitleDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test04SelectTitleByAll() {
		System.out.printf("%s()%n", "test04SelectTitleByAll");
		List<Title> titleList = dao.selectTitleByAll();
		Assert.assertNotNull(titleList);
		
		for(Title t : titleList) {
			System.out.println(t);
		}

	}

	@Test
	public void test05SelectTitleByNo() {
		System.out.printf("%s()%n", "test05SelectTitleByNo");
		Title title = new Title(3);
		Title searhTitle = dao.selectTitleByNo(title);
		Assert.assertNotNull(searhTitle);
		System.out.println(searhTitle);
		
	}

	@Test
	public void test01InsertTitle() {
		System.out.printf("%s()%n", "test01InsertTitle");
		Title newTitle = new Title(5, "바보");
		int res = dao.insertTitle(newTitle);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectTitleByNo(newTitle));
	}

	@Test
	public void test02UpdateTitle() {
		System.out.printf("%s()%n", "test02UpdateTitle");
		Title newTitle = new Title(5, "계약직");
		int res = dao.updateTitle(newTitle);
		Assert.assertEquals(1, res);
		System.out.println(newTitle);

		
	}

	@Test
	public void test03DeleteTitle() {
		System.out.printf("%s()%n", "test03DeleteTitle");
		int res = dao.deleteTitle(5);
		Assert.assertEquals(1, res);
		dao.selectTitleByAll().stream().forEach(System.out::println);

	}

}
