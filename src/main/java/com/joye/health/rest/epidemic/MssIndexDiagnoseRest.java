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

import com.joye.health.dao.epidemic.IMssIndexDiagnoseDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.PageParam;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.epidemic.MssIndexDiagnose;
import com.joye.health.util.RestUtil;

@Component
@Path("medicalEpidemic")
public class MssIndexDiagnoseRest {

	@Autowired
	private IMssIndexDiagnoseDao mssIndexDiagnoseDao;

	@Path("queryMssIndexDiagnose.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<MssIndexDiagnose> queryMssIndexDiagnose(@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate, @QueryParam("offset") @DefaultValue("0") int offset,
			@QueryParam("limit") @DefaultValue("100") int limit) throws AppException {
		PageParam page = new PageParam();
		page.constructPageNum(offset, limit);
		RestUtil.constructDate(page, startDate, endDate);
		return queryList(page);
	}
	
	private SuccessMsg<MssIndexDiagnose> queryList(PageParam page) {
		int total = mssIndexDiagnoseDao.queryMssIndexDiagnoseCount(page);
		List<MssIndexDiagnose> list = mssIndexDiagnoseDao.queryMssIndexDiagnose(page);
		SuccessMsg<MssIndexDiagnose> res = new SuccessMsg<MssIndexDiagnose>();
		res.setData(list);
		res.setTotal(total);
		return res;
	}

}
