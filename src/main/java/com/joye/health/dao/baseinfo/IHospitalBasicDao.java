package com.joye.health.dao.baseinfo;

import java.util.List;

import com.joye.health.model.baseinfo.HospitalBasic;
/**
 * 医疗机构基础信息Mapper
 * @author joyelew
 *
 */
public interface IHospitalBasicDao {
	public List<HospitalBasic> queryHospitalBasic();
}
