package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import dao.IDeptDao;
import entity.Dept;
import entity.Teacher;

public class DeptDaoImpl implements IDeptDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public int getDeptCount() {
		// TODO Auto-generated method stub
		return Integer.parseInt(sessionFactory.getCurrentSession().createCriteria(Dept.class).setProjection(Projections.rowCount()).uniqueResult().toString());
	}

	@Override
	public List<Dept> getDeptPage(int no, int size) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Dept.class).setFirstResult((no-1)*size).setMaxResults(size).list();
	}

	@Override
	public void deleteDept(Dept dept) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(dept);
		System.out.println("删除成功！");
	}

	@Override
	public void addOrUpdateDept(Dept dept) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(dept);
		System.out.println("操作成功！");
	}

	@Override
	public Dept getByNoDept(int dno) {
		// TODO Auto-generated method stub
		return (Dept) sessionFactory.getCurrentSession().get(Dept.class, (byte)dno);
	}

}
