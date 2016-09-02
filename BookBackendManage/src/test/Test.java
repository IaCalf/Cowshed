package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.IBookInfoDao;
import dao.IBookTypeDao;
import dao.impl.BookInfoDaoImpl;
import dao.impl.BookTypeDaoImpl;
import entity.BookInfo;
import entity.BookType;

public class Test {
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		IBookTypeDao dao = (BookTypeDaoImpl) act.getBean("bookTypeDao");
		List<BookType> li = dao.getBookTypeAll();
		
		
		for(BookType b:li){
		System.out.println(b.getTypeName());
		//System.out.println(b.getBookType().getTypeName());
		}
	}
}
