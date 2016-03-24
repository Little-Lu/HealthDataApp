package com.joye.health.dao.epidemic;

import java.util.List;

import com.joye.health.model.common.PageParam;
import com.joye.health.model.epidemic.MssIndexDiagnose;

public interface IMssIndexDiagnoseDao {
	public List<MssIndexDiagnose> queryMssIndexDiagnose(PageParam page);
	
	public int queryMssIndexDiagnoseCount(PageParam page);
}
