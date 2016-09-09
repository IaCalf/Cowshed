package cn.dms.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dms.dao.IDormmanagerDao;
import cn.dms.pojo.TDormmanager;
import cn.dms.services.IDormmanagerService;
/**
 * 宿管功能操作类
 */
@Service("dormmanagerService")
public class DormmanagerServiceImpl implements IDormmanagerService {
	
	@Resource
	private IDormmanagerDao dormmanagerDao;

	@Override
	public TDormmanager loginDormmanager(String userName, String password) {
		// TODO Auto-generated method stub
		TDormmanager dormmanager = new TDormmanager(userName, password);
		return dormmanagerDao.loginDormmanager(dormmanager);
	}

	@Override
	public int getDormmanagerCount() {
		// TODO Auto-generated method stub
		return dormmanagerDao.getDormmanagerCount();
	}

	@Override
	public List<TDormmanager> getDormmanagerByPage(int no, int size) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", (no-1)*size+1);
		map.put("size", no*size);
		return dormmanagerDao.getDormmanagerByPage(map);
	}

	@Override
	public List<TDormmanager> getDormmanagerByNamePage(String name, int no,
			int size) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "%"+name+"%");
		map.put("no", (no-1)*size+1);
		map.put("size", no*size);
		return dormmanagerDao.getDormmanagerByNamePage(map);
	}

	@Override
	public List<TDormmanager> getDormmanagerByUserNamePage(String name, int no,
			int size) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "%"+name+"%");
		map.put("no", (no-1)*size+1);
		map.put("size", no*size);
		return dormmanagerDao.getDormmanagerByNamePage(map);
	}

	@Override
	public void addTDormmanager(TDormmanager dormmanager) {
		// TODO Auto-generated method stub
		dormmanagerDao.addTDormmanager(dormmanager);
		System.out.println("添加成功！");
	}

	@Override
	public TDormmanager getTDormmanagerById(long dormmanid) {
		// TODO Auto-generated method stub
		return dormmanagerDao.getTDormmanagerById(dormmanid);
	}

	@Override
	public void updateTDormmanager(TDormmanager dormmanager) {
		// TODO Auto-generated method stub
		dormmanagerDao.updateTDormmanager(dormmanager);
		System.out.println("修改成功！");
	}

	@Override
	public void deleteTDormmanager(long dormmanid) {
		// TODO Auto-generated method stub
		dormmanagerDao.deleteTDormmanager(dormmanid);
		System.out.println("删除成功！");
	}
}
