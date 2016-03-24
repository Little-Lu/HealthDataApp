package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeResourceRecord;

public interface IHeResourceRecordDao {
	public List<HeResourceRecord> queryHeResourceRecord();
	public int insertHeResourceRecord(HeResourceRecord heResourceRecord);
	public int updateHeResourceRecord(HeResourceRecord heResourceRecord);
	public int deleteHeResourceRecord(String pk);
}
