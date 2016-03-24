package com.joye.health.rest.baseinfo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joye.health.dao.baseinfo.IHospitalBasicDao;
import com.joye.health.dao.baseinfo.IHospitalOtherDao;
import com.joye.health.model.baseinfo.HospitalBasic;
import com.joye.health.model.baseinfo.HospitalOther;
import com.joye.health.model.common.SuccessMsg;

@Component
@Path("baseInfo")
public class HospitalBasicRest {

	@Autowired
	private IHospitalBasicDao hospitalBasicDao;

	@Autowired
	private IHospitalOtherDao hospitalOtherDao;

	@Path("queryRegHospitalBasic.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HospitalBasic> queryRegHospitalBasic() {
		List<HospitalBasic> list = null;
			list = hospitalBasicDao.queryHospitalBasic();
		SuccessMsg<HospitalBasic> res = new SuccessMsg<HospitalBasic>();
		res.setData(list);
		return res;
	}

	@Path("queryRegHospitalOther.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HospitalOther> queryRegHospitalOther() {
		List<HospitalOther> list = hospitalOtherDao.queryHospitalOther();
		SuccessMsg<HospitalOther> res = new SuccessMsg<HospitalOther>();
		res.setData(list);
		return res;
	}
}
