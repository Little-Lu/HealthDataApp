package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeEventEndReport;


public interface IHeEventEndReportDao {
	public List<HeEventEndReport> queryHeEventEndReport();
	public int insertHeEventEndReport(HeEventEndReport heEventEndReport);
	public int updateHeEventEndReport(HeEventEndReport heEventEndReport);
	public int deleteHeEventEndReport(String pk);
}
