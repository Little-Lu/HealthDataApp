package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeUnitVehicleRecord;

public interface IHeUnitVehicleRecordDao {
	public List<HeUnitVehicleRecord> queryHeUnitVehicleRecord();
	public int insertHeUnitVehicleRecord(HeUnitVehicleRecord heUnitVehicleRecord);
	public int updateHeUnitVehicleRecord(HeUnitVehicleRecord heUnitVehicleRecord);
	public int deleteHeUnitVehicleRecord(String pk);
}
