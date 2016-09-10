package cn.dms.dao;

import java.util.List;
import java.util.Map;

import cn.dms.pojo.TStudent;

public interface IStudentDao {
	//登录功能
	public TStudent loginStudent(TStudent tStudent);
	//获取全部学生信息总条数
	public int getStudentCount();
	//获取分页信息
	public List<TStudent> getStudentByPage(Map<String, Object> map);
	//动态模糊查询
	public List<TStudent> getStudentByNamePage(Map<String, Object> map);
	//增加学生信息
	public void addTStudent(TStudent student);
	//根据ID查询学生信息 
	public TStudent getStudentById(long studentid);
	//修改学生信息
	public void updateTStudent(TStudent student);
	//删除学生信息
	public void deleteTStudent(long studentid);
	//添加学生所属的楼栋
	public void updateTDormbuild(Map<String, Object> map);
}
