package biz.impl;

import java.util.List;

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
	public int getBookInfoCount() {
		// TODO Auto-generated method stub
		return bookInfoDao.getBookInfoCount();
	}

	@Override
	public List<BookInfo> getBookInfoByPage(int no, int size) {
		// TODO Auto-generated method stub
		return bookInfoDao.getBookInfoByPage(no, size);
	}

	@Override
	public List<BookInfo> getNameBookInfoByPage(String name, int no, int size) {
		// TODO Auto-generated method stub
		return bookInfoDao.getNameBookInfoByPage(name, no, size);
	}

	@Override
	public BookInfo getBookInfoById(int bookId) {
		// TODO Auto-generated method stub
		return bookInfoDao.getBookInfoById((long)bookId);
	}

	@Override
	public void deleteBookInfo(int bookId) {
		// TODO Auto-generated method stub
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookId((long)bookId);
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

}
