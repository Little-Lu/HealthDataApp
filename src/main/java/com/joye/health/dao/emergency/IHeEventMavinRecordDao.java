package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeEventMavinRecord;

public interface IHeEventMavinRecordDao {
	public List<HeEventMavinRecord> queryHeEventMavinRecord();
	public int insertHeEventMavinRecord(HeEventMavinRecord heEventMavinRecord);
	public int updateHeEventMavinRecord(HeEventMavinRecord heEventMavinRecord);
	public int deleteHeEventMavinRecord(String pk);
}
