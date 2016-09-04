package biz.impl;

import java.util.List;

import org.hibernate.Query;

import dao.IBookInfoDao;
import biz.IBookInfoBiz;
import entity.BookInfo;

public class BookInfoBizImpl implements IBookInfoBiz {
	private IBookInfoDao bookInfoDao;
	
	
	public IBookInfoDao getBookInfoDao() {
		return bookInfoDao;
	}

	public void setBookInfoDao(IBookInfoDao bookInfoDao) {
		this.bookInfoDao = bookInfoDao;
	}

	@Override
	public List<BookInfo> getNameBookInfoByPage(String name, int no, int size) {
		// TODO Auto-generated method stub
		return bookInfoDao.getNameBookInfoByPage(name, no, size);
	}

	@Override
	public BookInfo getBookInfoById(long bookId) {
		// TODO Auto-generated method stub
		return bookInfoDao.getBookInfoById(bookId);
	}

	@Override
	public void deleteBookInfo(long bookId) {
		// TODO Auto-generated method stub
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookId(bookId);
		bookInfoDao.deleteBookInfo(bookInfo);
		System.out.println("删除成功！");
	}

	@Override
	public void updateBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		bookInfoDao.updateBookInfo(bookInfo);
		System.out.println("修改成功！");
	}

	@Override
	public void addBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		bookInfoDao.addBookInfo(bookInfo);
		System.out.println("添加成功！");
	}

	@Override
	public int getBookInfoByNameCount(String name) {
		// TODO Auto-generated method stub
		return bookInfoDao.getBookInfoByNameCount(name);
	}

}
