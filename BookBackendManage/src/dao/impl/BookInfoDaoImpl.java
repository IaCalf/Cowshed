package dao.impl;

import java.util.List;

import org.hibernate.Query;
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
	public List<BookInfo> getNameBookInfoByPage(String name, int no, int size) {
		// TODO Auto-generated method stub
		Query createQuery = null;
		String hql="from BookInfo b where b.bookName like :bookName";
		if(name == null){
			hql="from BookInfo";
			createQuery = sessionFactory.getCurrentSession().createQuery(hql);
		}else{
			createQuery = sessionFactory.getCurrentSession().createQuery(hql).setString("bookName", "%"+name+"%");
		}
		return createQuery.setFirstResult((no-1)*size).setMaxResults(size).list();
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

	@Override
	public int getBookInfoByNameCount(String name) {
		// TODO Auto-generated method stub
		Query createQuery = null;
		String hql="select count(*) from BookInfo b where b.bookName like :bookName";
		if(name == null){
			hql="select count(*) from BookInfo";
			createQuery = sessionFactory.getCurrentSession().createQuery(hql);
		}else{
			createQuery = sessionFactory.getCurrentSession().createQuery(hql).setString("bookName", "%"+name+"%");
		}
		
		return Integer.valueOf(createQuery.uniqueResult().toString());
	}

}
