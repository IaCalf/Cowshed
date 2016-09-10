package cn.dms.dao;

import java.util.List;

import cn.dms.pojo.TDormbuild;

/**
 * 宿舍楼
 * @author yi
 *
 */
public interface IDormbuildDao {
	//查询宿舍楼信息
	public List<TDormbuild> getTDormbuildAll();
}
