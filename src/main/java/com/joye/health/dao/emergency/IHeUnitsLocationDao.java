package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeUnitsLocation;

public interface IHeUnitsLocationDao {
	public List<HeUnitsLocation> queryHeUnitsLocation();
	public int insertHeUnitsLocation(HeUnitsLocation heUnitsLocation);
	public int updateHeUnitsLocation(HeUnitsLocation heUnitsLocation);
	public int deleteHeUnitsLocation(String unitCode);
}
