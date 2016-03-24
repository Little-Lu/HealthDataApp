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

import com.joye.health.dao.epidemic.IEaNetDataDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.PageParam;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.epidemic.EaNetData;
import com.joye.health.util.RestUtil;

@Component
@Path("medicalEpidemic")
public class EaNetDataRest {

	@Autowired
	private IEaNetDataDao eaNetDataDao;

	@Path("queryEaNetData.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<EaNetData> queryEaNetData(@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate, @QueryParam("offset") @DefaultValue("0") int offset,
			@QueryParam("limit") @DefaultValue("100") int limit) throws AppException {
		PageParam page = new PageParam();
		page.constructPageNum(offset, limit);
		RestUtil.constructDate(page, startDate, endDate);
		return queryList(page);
	}

	private SuccessMsg<EaNetData> queryList(PageParam page) {
		int total = eaNetDataDao.queryEaNetDataCount(page);
		List<EaNetData> list = eaNetDataDao.queryEaNetData(page);
		SuccessMsg<EaNetData> res = new SuccessMsg<EaNetData>();
		res.setData(list);
		res.setTotal(total);
		return res;
	}

}
