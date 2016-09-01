package biz;

import java.util.List;

import entity.Dept;

public interface IDeptBiz {
	//获取总条数
	public int getDeptCount();
	//获取分页数据
	public List<Dept> getDeptPage(int no,int size);
	///增加和修改部门
	public void addOrUpdateDept(Dept dept);
	//删除部门
	public void deleteDept(int dno);
	//根据编号查询
	public Dept getByNoDept(int dno);
}
