package biz.impl;

import java.util.List;

import dao.IBookTypeDao;
import entity.BookType;
import biz.IBookTypeBiz;

public class BookTypeBizImpl implements IBookTypeBiz {
	private IBookTypeDao bookTypeDao;
	
	
	public IBookTypeDao getBookTypeDao() {
		return bookTypeDao;
	}

	public void setBookTypeDao(IBookTypeDao bookTypeDao) {
		this.bookTypeDao = bookTypeDao;
	}

	@Override
	public List<BookType> getBookTypeAll() {
		// TODO Auto-generated method stub
		return bookTypeDao.getBookTypeAll();
	}

	@Override
	public BookType getBookTypeByName(String name) {
		// TODO Auto-generated method stub
		return bookTypeDao.getBookTypeByName(name);
	}

}
