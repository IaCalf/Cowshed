package cn.dms.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dms.dao.IDormbuildDao;
import cn.dms.pojo.TDormbuild;
import cn.dms.services.IDormbuildService;
@Service("dormbuildService")
public class DormbuildServiceImpl implements IDormbuildService {
	
	@Resource
	private IDormbuildDao dormbuildDao;
	
	@Override
	public List<TDormbuild> getTDormbuildAll() {
		// TODO Auto-generated method stub
		return dormbuildDao.getTDormbuildAll();
	}

}
