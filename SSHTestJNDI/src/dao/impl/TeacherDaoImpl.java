package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import dao.ITeacherDao;
import entity.Teacher;

public class TeacherDaoImpl implements ITeacherDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int getTeacherCount() {
		// TODO Auto-generated method stub
		return Integer.parseInt(sessionFactory.getCurrentSession().createCriteria(Teacher.class).setProjection(Projections.rowCount()).uniqueResult().toString());
	}

	@Override
	public List<Teacher> getTeacherPage(int no, int size) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Teacher.class).setFirstResult((no-1)*size).setMaxResults(size).list();
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(teacher);
		System.out.println("删除成功！");
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(teacher);
		System.out.println("添加成功！");
	}

	@Override
	public void updataTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(teacher);;
		System.out.println("修改成功！");
	}

	@Override
	public Teacher getByNoTeacher(int tno) {
		// TODO Auto-generated method stub
		return (Teacher) sessionFactory.getCurrentSession().get(Teacher.class, (short)tno);
	}

}
