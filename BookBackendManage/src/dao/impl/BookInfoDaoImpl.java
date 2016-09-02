package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.IBookInfoDao;
import entity.BookInfo;

public class BookInfoDaoImpl implements IBookInfoDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int getBookInfoCount() {
		// TODO Auto-generated method stub
		return Integer.parseInt(sessionFactory.getCurrentSession().createQuery("select count(*) from BookInfo").uniqueResult().toString());
	}

	@Override
	public List<BookInfo> getBookInfoByPage(int no, int size) {
		// TODO Auto-generated method stub
		//from BookInfo order by creationTime
		return sessionFactory.getCurrentSession().createQuery("from BookInfo").setFirstResult((no-1)*size).setMaxResults(size).list();
	}

	@Override
	public List<BookInfo> getNameBookInfoByPage(String name, int no, int size) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from BookInfo b where b.bookName like :bookName").setString("bookName", "%"+name+"%").setFirstResult((no-1)*size).setMaxResults(size).list();
	}

	@Override
	public BookInfo getBookInfoById(long bookId) {
		// TODO Auto-generated method stub
		return (BookInfo) sessionFactory.getCurrentSession().createQuery("from BookInfo b where b.bookId = :bookId").setLong("bookId", bookId).uniqueResult();
	}

	@Override
	public void deleteBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(bookInfo);
	}

	@Override
	public void updateBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(bookInfo);
	}

	@Override
	public void addBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(bookInfo);
	}

}
