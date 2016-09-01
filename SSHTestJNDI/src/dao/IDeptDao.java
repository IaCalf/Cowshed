package dao;

import java.util.List;

import entity.Dept;

public interface IDeptDao {
	//获取总条数
	public int getDeptCount();
	//获取分页数据
	public List<Dept> getDeptPage(int no,int size);
	//增加和修改部门
	public void addOrUpdateDept(Dept dept);
	//删除部门
	public void deleteDept(Dept dept);
	//根据编号查询
	public Dept getByNoDept(int dno);
}
