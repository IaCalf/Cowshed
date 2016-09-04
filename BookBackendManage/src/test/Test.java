package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.IBookInfoBiz;
import biz.impl.BookInfoBizImpl;
import dao.IBookInfoDao;
import dao.IBookTypeDao;
import dao.impl.BookInfoDaoImpl;
import dao.impl.BookTypeDaoImpl;
import entity.BookInfo;
import entity.BookType;

public class Test {
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		IBookInfoBiz dao = (BookInfoBizImpl) act.getBean("bookInfoBiz");
		List<BookInfo> li = dao.getNameBookInfoByPage("98", 1, 5);
		
		
		for(BookInfo b:li){
		System.out.println(b.getBookName());
		//System.out.println(b.getBookType().getTypeName());
		}
	}
}
