package com.joye.health.rest.baseinfo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joye.health.dao.baseinfo.ICvAreaDictDao;
import com.joye.health.model.baseinfo.CvAreaDict;
import com.joye.health.model.common.SuccessMsg;
@Component
@Path("baseInfo")
public class CvAreaDictRest {

    @Autowired
    private ICvAreaDictDao cvAreaDictDao;
	
	@Path("queryCvAreaDict.do")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public SuccessMsg<CvAreaDict> queryRegCvAreaDict() {
    	List<CvAreaDict> list =  cvAreaDictDao.queryCvAreaDict();
    	SuccessMsg<CvAreaDict> res = new SuccessMsg<CvAreaDict>();
    	res.setData(list);
    	return res;
    }
    
}
