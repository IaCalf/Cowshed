package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.IBookTypeDao;
import entity.BookType;

public class BookTypeDaoImpl implements IBookTypeDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<BookType> getBookTypeAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from BookType").list();
	}

	@Override
	public BookType getBookTypeByName(String name) {
		// TODO Auto-generated method stub
		return (BookType) sessionFactory.getCurrentSession().createQuery("from BookTypeb b where b.typeName = :typeName").setString("typeName", name).uniqueResult();
	}

}
