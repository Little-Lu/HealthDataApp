package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeEventPersonReport;


public interface IHeEventPersonReportDao {
	public List<HeEventPersonReport> queryHeEventPersonReport();
	public int insertHeEventPersonReport(HeEventPersonReport heEventPersonReport);
	public int updateHeEventPersonReport(HeEventPersonReport heEventPersonReport);
	public int deleteHeEventPersonReport(String pk);
}
