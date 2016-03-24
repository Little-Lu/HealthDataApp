package com.joye.health.rest.emergency;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joye.health.dao.emergency.IHeEventContingencyRecordDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeEventContingencyRecord;

@Component
@Path("yjzh")
public class HeEventContingencyRecordRest {

	@Autowired
	private IHeEventContingencyRecordDao heEventContingencyRecordDao;

	@Path("queryHeEventContingencyRecord.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeEventContingencyRecord> queryRegHeEventContingencyRecord() {
		List<HeEventContingencyRecord> list = heEventContingencyRecordDao.queryHeEventContingencyRecord();
		SuccessMsg<HeEventContingencyRecord> res = new SuccessMsg<HeEventContingencyRecord>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeEventContingencyRecord.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heEventContingencyRecordDao.deleteHeEventContingencyRecord(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeEventContingencyRecord successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeEventContingencyRecord with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeEventContingencyRecord.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeEventContingencyRecord(HeEventContingencyRecord units) throws AppException {
		heEventContingencyRecordDao.insertHeEventContingencyRecord(units);
		return Response.status(Response.Status.CREATED).entity("A new HeEventContingencyRecord has been created").build();
	}
	
	@POST
	@Path("updateHeEventContingencyRecord.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeEventContingencyRecord(HeEventContingencyRecord units) throws AppException {
		heEventContingencyRecordDao.updateHeEventContingencyRecord(units);
		return Response.status(Response.Status.CREATED).entity("A HeEventContingencyRecord has been updated").build();
	}

}
