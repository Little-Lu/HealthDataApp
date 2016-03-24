package com.joye.health.dao.baseinfo;

import java.util.List;

import com.joye.health.model.baseinfo.HealthOfficerOther;
import com.joye.health.model.common.PageParam;

public interface IHealthOfficerOtherDao {
	public List<HealthOfficerOther> queryHealthOfficerOther(PageParam page);
	
	public int queryHealthOfficerOtherCount();
}
