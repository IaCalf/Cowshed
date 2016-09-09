package cn.dms.services;

import java.util.List;
import java.util.Map;

import cn.dms.pojo.TDormmanager;

/**
 * 宿管功能操作类
 */
public interface IDormmanagerService {
	//登录功能
	public TDormmanager loginDormmanager(String userName, String password);
	//获取全部用户信息总条数
	public int getDormmanagerCount();
	//获取分页信息
	public List<TDormmanager> getDormmanagerByPage(int no, int size);
	//模糊查询
	public List<TDormmanager> getDormmanagerByNamePage(String name, int no, int size);
	//用户名模糊查询
	public List<TDormmanager> getDormmanagerByUserNamePage(String name, int no, int size);
	//增加宿舍管理员
	public void addTDormmanager(TDormmanager dormmanager);
	//根据ID查询舍管理员信息 
	public TDormmanager getTDormmanagerById(long dormmanid);
	//修改宿舍管理员信息
	public void updateTDormmanager(TDormmanager dormmanager);
	//删除宿舍管理员信息
	public void deleteTDormmanager(long dormmanid);
}
