package com.joye.health.dao.epidemic;

import java.util.List;

import com.joye.health.model.common.PageParam;
import com.joye.health.model.epidemic.MssIndexOperation;

public interface IMssIndexOperationDao {
	public List<MssIndexOperation> queryMssIndexOperation(PageParam page);
	
	public int queryMssIndexOperationCount(PageParam page);
}
