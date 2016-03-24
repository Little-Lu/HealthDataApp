package com.joye.health.rest.emergency;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joye.health.dao.emergency.ICvEventClassDictDao;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.CvEventClassDict;

@Component
@Path("yjzh")
public class CvEventClassDictRest {

	@Autowired
	private ICvEventClassDictDao cvEventClassDictDao;

	@Path("queryCvEventClassDict.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<CvEventClassDict> queryRegCvEventClassDict() {
		List<CvEventClassDict> list = cvEventClassDictDao.queryCvEventClassDict();
		SuccessMsg<CvEventClassDict> res = new SuccessMsg<CvEventClassDict>();
		res.setData(list);
		return res;
	}

}
