package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeTroopMemberRecord;

public interface IHeTroopMemberRecordDao {
	public List<HeTroopMemberRecord> queryHeTroopMemberRecord();
	public int insertHeTroopMemberRecord(HeTroopMemberRecord heTroopMemberRecord);
	public int updateHeTroopMemberRecord(HeTroopMemberRecord heTroopMemberRecord);
	public int deleteHeTroopMemberRecord(String pk);
}
