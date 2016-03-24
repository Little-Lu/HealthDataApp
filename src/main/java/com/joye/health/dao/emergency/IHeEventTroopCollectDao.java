package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeEventTroopCollect;


public interface IHeEventTroopCollectDao {
	public List<HeEventTroopCollect> queryHeEventTroopCollect();
	public int insertHeEventTroopCollect(HeEventTroopCollect heEventTroopCollect);
	public int updateHeEventTroopCollect(HeEventTroopCollect heEventTroopCollect);
	public int deleteHeEventTroopCollect(String pk);
}
