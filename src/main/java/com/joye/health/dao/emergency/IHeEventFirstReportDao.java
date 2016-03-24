package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeEventFirstReport;


public interface IHeEventFirstReportDao {
	public List<HeEventFirstReport> queryHeEventFirstReport();
	public int insertHeEventFirstReport(HeEventFirstReport heEventFirstReport);
	public int updateHeEventFirstReport(HeEventFirstReport heEventFirstReport);
	public int deleteHeEventFirstReport(String pk);
}
