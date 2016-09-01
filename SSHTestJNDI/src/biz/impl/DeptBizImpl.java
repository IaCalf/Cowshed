package biz.impl;

import java.util.List;

import dao.IDeptDao;
import entity.Dept;
import biz.IDeptBiz;

public class DeptBizImpl implements IDeptBiz {
	private IDeptDao deptDao;

	public IDeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public int getDeptCount() {
		// TODO Auto-generated method stub
		return deptDao.getDeptCount();
	}

	@Override
	public List<Dept> getDeptPage(int no, int size) {
		// TODO Auto-generated method stub
		return deptDao.getDeptPage(no, size);
	}

	@Override
	public void deleteDept(int dno) {
		// TODO Auto-generated method stub
		Dept dept = new Dept();
		dept.setDeptno((byte)dno);
		deptDao.deleteDept(dept);
	}

	@Override
	public void addOrUpdateDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.addOrUpdateDept(dept);
	}

	@Override
	public Dept getByNoDept(int dno) {
		// TODO Auto-generated method stub
		return deptDao.getByNoDept(dno);
	}

}
