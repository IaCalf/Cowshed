package cn.dms.services;

import cn.dms.pojo.TAdmin;

/**
 * 管理员能操作类
 */

public interface IAdminService {
	//登录功能
	public TAdmin loginTAdmin(String userName, String password);
}
