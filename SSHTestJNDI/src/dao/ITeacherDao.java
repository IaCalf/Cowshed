package dao;

import java.util.List;

import entity.Dept;
import entity.Teacher;

public interface ITeacherDao {
	//获取总条数
	public int getTeacherCount();
	//获取分页数据
	public List<Teacher> getTeacherPage(int no,int size);
	//添加教员
	public void addTeacher(Teacher teacher);
	//修改教员
	public void updataTeacher(Teacher teacher);
	//删除教员
	public void deleteTeacher(Teacher teacher);
	//根据编号查询
	public Teacher getByNoTeacher(int tno);
}
