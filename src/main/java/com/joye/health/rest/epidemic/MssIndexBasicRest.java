package com.joye.health.rest.epidemic;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joye.health.dao.epidemic.IMssIndexBasicDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.PageParam;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.epidemic.MssIndexBasic;
import com.joye.health.util.RestUtil;

@Component
@Path("medicalEpidemic")
public class MssIndexBasicRest {

	@Autowired
	private IMssIndexBasicDao mssIndexBasicDao;

	@Path("queryMssIndexBasic.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<MssIndexBasic> queryMssIndexBasic(@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate, @QueryParam("offset") @DefaultValue("0") int offset,
			@QueryParam("limit") @DefaultValue("100") int limit) throws AppException {
		PageParam page = new PageParam();
		page.constructPageNum(offset, limit);
		RestUtil.constructDate(page, startDate, endDate);
		return queryList(page);
	}

	private SuccessMsg<MssIndexBasic> queryList(PageParam page) {
		int total = mssIndexBasicDao.queryMssIndexBasicCount(page);
		List<MssIndexBasic> list = mssIndexBasicDao.queryMssIndexBasic(page);
		SuccessMsg<MssIndexBasic> res = new SuccessMsg<MssIndexBasic>();
		res.setData(list);
		res.setTotal(total);
		return res;
	}

}
