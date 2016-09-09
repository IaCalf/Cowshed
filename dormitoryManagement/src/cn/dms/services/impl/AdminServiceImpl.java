package cn.dms.services.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dms.dao.IAdminDao;
import cn.dms.pojo.TAdmin;
import cn.dms.services.IAdminService;
/**
 * 管理员能操作类
 */
@Service("adminService")
public class AdminServiceImpl implements IAdminService {
	
	@Resource
	private IAdminDao adminDao;
	
	@Override
	public TAdmin loginTAdmin(String userName, String password) {
		// TODO Auto-generated method stub
		System.out.println("===adminDao====");
		TAdmin tAdmin = new TAdmin(userName, password);
		return adminDao.loginTAdmin(tAdmin);
	}
}
