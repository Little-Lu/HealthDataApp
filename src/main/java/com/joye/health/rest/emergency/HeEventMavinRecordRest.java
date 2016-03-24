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

import com.joye.health.dao.emergency.IHeEventMavinRecordDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeEventMavinRecord;

@Component
@Path("yjzh")
public class HeEventMavinRecordRest {

	@Autowired
	private IHeEventMavinRecordDao heEventMavinRecordDao;

	@Path("queryHeEventMavinRecord.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeEventMavinRecord> queryRegHeEventMavinRecord() {
		List<HeEventMavinRecord> list = heEventMavinRecordDao.queryHeEventMavinRecord();
		SuccessMsg<HeEventMavinRecord> res = new SuccessMsg<HeEventMavinRecord>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeEventMavinRecord.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heEventMavinRecordDao.deleteHeEventMavinRecord(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeEventMavinRecord successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeEventMavinRecord with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeEventMavinRecord.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeEventMavinRecord(HeEventMavinRecord units) throws AppException {
		heEventMavinRecordDao.insertHeEventMavinRecord(units);
		return Response.status(Response.Status.CREATED).entity("A new HeEventMavinRecord has been created").build();
	}
	
	@POST
	@Path("updateHeEventMavinRecord.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeEventMavinRecord(HeEventMavinRecord units) throws AppException {
		heEventMavinRecordDao.updateHeEventMavinRecord(units);
		return Response.status(Response.Status.CREATED).entity("A HeEventMavinRecord has been updated").build();
	}

}
