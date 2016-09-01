package biz.impl;

import java.util.List;

import dao.ITeacherDao;
import entity.Dept;
import entity.Teacher;
import biz.ITeacherBiz;

public class TeacherBizImpl implements ITeacherBiz {
	private ITeacherDao teacherDao;
	
	public ITeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(ITeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public int getTeacherCount() {
		// TODO Auto-generated method stub
		return teacherDao.getTeacherCount();
	}

	@Override
	public List<Teacher> getTeacherPage(int no, int size) {
		// TODO Auto-generated method stub
		return teacherDao.getTeacherPage(no, size);
	}

	@Override
	public void deleteTeacher(int tno) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.setTno((short)tno);
		teacherDao.deleteTeacher(teacher);
		
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.addTeacher(teacher);
	}

	@Override
	public void updataTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.updataTeacher(teacher);
	}

	@Override
	public Teacher getByNoTeacher(int tno) {
		// TODO Auto-generated method stub
		return teacherDao.getByNoTeacher(tno);
	}

}
