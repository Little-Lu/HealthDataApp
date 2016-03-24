package com.joye.health.dao.epidemic;

import java.util.List;

import com.joye.health.model.common.PageParam;
import com.joye.health.model.epidemic.MssOutDiagnosis;

public interface IMssOutDiagnosisDao {
	public List<MssOutDiagnosis> queryMssOutDiagnosis(PageParam page);
	
	public int queryMssOutDiagnosisCount(PageParam page);
}
