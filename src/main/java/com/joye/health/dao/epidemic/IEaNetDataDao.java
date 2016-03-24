package com.joye.health.dao.epidemic;

import java.util.List;

import com.joye.health.model.common.PageParam;
import com.joye.health.model.epidemic.EaNetData;

public interface IEaNetDataDao {
	public List<EaNetData> queryEaNetData(PageParam page);
	
	public int queryEaNetDataCount(PageParam page);
}
