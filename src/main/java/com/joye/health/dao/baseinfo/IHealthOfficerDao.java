package com.joye.health.dao.baseinfo;

import java.util.List;

import com.joye.health.model.baseinfo.HealthOfficer;
import com.joye.health.model.common.PageParam;

public interface IHealthOfficerDao {
	public List<HealthOfficer> queryHealthOfficer(PageParam page);
	
	public int queryHealthOfficerCount();
}
