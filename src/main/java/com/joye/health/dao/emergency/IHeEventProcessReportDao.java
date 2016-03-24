package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeEventProcessReport;


public interface IHeEventProcessReportDao {
	public List<HeEventProcessReport> queryHeEventProcessReport();
	public int insertHeEventProcessReport(HeEventProcessReport heEventProcessReport);
	public int updateHeEventProcessReport(HeEventProcessReport heEventProcessReport);
	public int deleteHeEventProcessReport(String pk);
}
