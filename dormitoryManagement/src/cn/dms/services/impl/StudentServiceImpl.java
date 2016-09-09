package cn.dms.services.impl;
/**
 * 学生功能操作类
 */
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

}
