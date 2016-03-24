package com.joye.health.dao.epidemic;

import java.util.List;

import com.joye.health.model.common.PageParam;
import com.joye.health.model.epidemic.MssIndexTransfusion;

public interface IMssIndexTransfusionDao {
	public List<MssIndexTransfusion> queryMssIndexTransfusion(PageParam page);
	
	public int queryMssIndexTransfusionCount(PageParam page);
}
