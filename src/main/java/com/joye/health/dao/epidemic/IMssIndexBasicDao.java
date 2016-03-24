package com.joye.health.dao.epidemic;

import java.util.List;

import com.joye.health.model.common.PageParam;
import com.joye.health.model.epidemic.MssIndexBasic;

public interface IMssIndexBasicDao {
	public List<MssIndexBasic> queryMssIndexBasic(PageParam page);
	
	public int queryMssIndexBasicCount(PageParam page);
}
