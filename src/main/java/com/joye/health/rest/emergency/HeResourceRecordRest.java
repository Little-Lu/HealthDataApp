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

import com.joye.health.dao.emergency.IHeResourceRecordDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeResourceRecord;

@Component
@Path("yjzh")
public class HeResourceRecordRest {

	@Autowired
	private IHeResourceRecordDao heResourceRecordDao;

	@Path("queryHeResourceRecord.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeResourceRecord> queryRegHeResourceRecord() {
		List<HeResourceRecord> list = heResourceRecordDao.queryHeResourceRecord();
		SuccessMsg<HeResourceRecord> res = new SuccessMsg<HeResourceRecord>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeResourceRecord.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heResourceRecordDao.deleteHeResourceRecord(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeResourceRecord successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeResourceRecord with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeResourceRecord.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeResourceRecord(HeResourceRecord units) throws AppException {
		heResourceRecordDao.insertHeResourceRecord(units);
		return Response.status(Response.Status.CREATED).entity("A new HeResourceRecord has been created").build();
	}
	
	@POST
	@Path("updateHeResourceRecord.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeResourceRecord(HeResourceRecord units) throws AppException {
		heResourceRecordDao.updateHeResourceRecord(units);
		return Response.status(Response.Status.CREATED).entity("A HeResourceRecord has been updated").build();
	}
}
