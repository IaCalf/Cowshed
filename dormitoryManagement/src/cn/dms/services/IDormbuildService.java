package cn.dms.services;

import java.util.List;

import cn.dms.pojo.TDormbuild;

public interface IDormbuildService {
	//查询宿舍楼信息
	public List<TDormbuild> getTDormbuildAll();
}
