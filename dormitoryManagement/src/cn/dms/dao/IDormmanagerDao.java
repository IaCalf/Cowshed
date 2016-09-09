package cn.dms.dao;

import java.util.List;
import java.util.Map;

import cn.dms.pojo.TDormmanager;

public interface IDormmanagerDao {
	//登录功能
	public TDormmanager loginDormmanager(TDormmanager dormmanager);
	//获取全部用户信息总条数
	public int getDormmanagerCount();
	//获取分页信息
	public List<TDormmanager> getDormmanagerByPage(Map<String, Object> map);
	//姓名模糊查询
	public List<TDormmanager> getDormmanagerByNamePage(Map<String, Object> map);
	//用户名模糊查询
	public List<TDormmanager> getDormmanagerByUserNamePage(Map<String, Object> map);
	//增加宿舍管理员
	public void addTDormmanager(TDormmanager dormmanager);
	//根据ID查询舍管理员信息 
	public TDormmanager getTDormmanagerById(long dormmanid);
	//修改宿舍管理员信息
	public void updateTDormmanager(TDormmanager dormmanager);
	//删除宿舍管理员信息
	public void deleteTDormmanager(long dormmanid);
}
