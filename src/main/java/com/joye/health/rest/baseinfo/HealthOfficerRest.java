package com.joye.health.rest.baseinfo;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joye.health.dao.baseinfo.IHealthOfficerDao;
import com.joye.health.dao.baseinfo.IHealthOfficerOtherDao;
import com.joye.health.model.baseinfo.HealthOfficer;
import com.joye.health.model.baseinfo.HealthOfficerOther;
import com.joye.health.model.common.PageParam;
import com.joye.health.model.common.SuccessMsg;

@Component
@Path("baseInfo")
public class HealthOfficerRest {

	@Autowired
	private IHealthOfficerDao healthOfficerDao;

	@Autowired
	private IHealthOfficerOtherDao healthOfficerOtherDao;

	@Path("queryRegHealthOfficerInfo.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HealthOfficer> queryRegHealthOfficer(@QueryParam("offset") @DefaultValue("0") int offset,@QueryParam("limit") @DefaultValue("100") int limit) {
		PageParam page = new PageParam();
		int startNum = offset +1;
		int endNum = offset + limit;
		page.setStartNum(startNum);
		page.setEndNum(endNum);
		int total = healthOfficerDao.queryHealthOfficerCount();
		List<HealthOfficer> list = healthOfficerDao.queryHealthOfficer(page);
		SuccessMsg<HealthOfficer> res = new SuccessMsg<HealthOfficer>();
		res.setTotal(total);
		res.setData(list);
		return res;
	}

	@Path("queryRegHealthOfficerOther.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HealthOfficerOther> queryRegHealthOfficerOther(@QueryParam("offset") @DefaultValue("0") int offset,@QueryParam("limit") @DefaultValue("100") int limit) {
		PageParam page = new PageParam();
		int startNum = offset +1;
		int endNum = offset + limit;
		page.setStartNum(startNum);
		page.setEndNum(endNum);
		int total = healthOfficerOtherDao.queryHealthOfficerOtherCount();
		List<HealthOfficerOther> list = healthOfficerOtherDao.queryHealthOfficerOther(page);
		SuccessMsg<HealthOfficerOther> res = new SuccessMsg<HealthOfficerOther>();
		res.setData(list);
		res.setTotal(total);
		return res;
	}
}
