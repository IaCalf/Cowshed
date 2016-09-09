package cn.dms.services;

import cn.dms.pojo.TStudent;

/**
 * 学生功能操作类
 */

public interface IStudentService {
	//登录功能
	public TStudent loginStudent(String userName, String password);
}
