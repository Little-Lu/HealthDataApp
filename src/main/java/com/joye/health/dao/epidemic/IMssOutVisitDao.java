package com.joye.health.dao.epidemic;

import java.util.List;

import com.joye.health.model.common.PageParam;
import com.joye.health.model.epidemic.MssOutVisit;


public interface IMssOutVisitDao {
	public List<MssOutVisit> queryMssOutVisit(PageParam page);
	
	public int queryMssOutVisitCount(PageParam page);
}
