package cn.dms.services.impl;
/**
 * 学生功能操作类
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dms.dao.IStudentDao;
import cn.dms.pojo.TStudent;
import cn.dms.services.IStudentService;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
	@Resource
	private IStudentDao studentDao;

	@Override
	public TStudent loginStudent(String userName, String password) {
		// TODO Auto-generated method stub
		TStudent tStudent = new TStudent(userName, password);
		return studentDao.loginStudent(tStudent);
	}

	@Override
	public int getStudentCount() {
		// TODO Auto-generated method stub
		return studentDao.getStudentCount();
	}

	@Override
	public List<TStudent> getStudentByPage(int no, int size) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", (no-1)*size+1);
		map.put("size", no*size);
		return studentDao.getStudentByPage(map);
	}

	@Override
	public List<TStudent> getStudentByNamePage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		return studentDao.getStudentByNamePage(map);
	}

	@Override
	public void addTStudent(TStudent student) {
		// TODO Auto-generated method stub
		studentDao.addTStudent(student);
		System.out.println("添加成功！");
	}

	@Override
	public TStudent getStudentById(long studentid) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(studentid);
	}

	@Override
	public void updateTStudent(TStudent student) {
		// TODO Auto-generated method stub
		studentDao.updateTStudent(student);
		System.out.println("修改成功！");
	}

	@Override
	public void deleteTStudent(long studentid) {
		// TODO Auto-generated method stub
		studentDao.deleteTStudent(studentid);
		System.out.println("删除成功！");
	}

	@Override
	public void updateTDormbuild(long dormbuildid, long studentid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dormbuildid", dormbuildid);
		map.put("studentid", studentid);
		studentDao.updateTDormbuild(map);
		System.out.println("修改管理楼栋成功！");
	}

}
