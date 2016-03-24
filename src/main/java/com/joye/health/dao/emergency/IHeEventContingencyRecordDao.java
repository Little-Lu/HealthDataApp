package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeEventContingencyRecord;


public interface IHeEventContingencyRecordDao {
	public List<HeEventContingencyRecord> queryHeEventContingencyRecord();
	public int insertHeEventContingencyRecord(HeEventContingencyRecord heEventContingencyRecord);
	public int updateHeEventContingencyRecord(HeEventContingencyRecord heEventContingencyRecord);
	public int deleteHeEventContingencyRecord(String pk);
}
