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

import com.joye.health.dao.emergency.IHeTroopMemberRecordDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeTroopMemberRecord;

@Component
@Path("yjzh")
public class HeTroopMemberRecordRest {

	@Autowired
	private IHeTroopMemberRecordDao heTroopMemberRecordDao;

	@Path("queryHeTroopMemberRecord.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeTroopMemberRecord> queryRegHeTroopMemberRecord() {
		List<HeTroopMemberRecord> list = heTroopMemberRecordDao.queryHeTroopMemberRecord();
		SuccessMsg<HeTroopMemberRecord> res = new SuccessMsg<HeTroopMemberRecord>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeTroopMemberRecord.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heTroopMemberRecordDao.deleteHeTroopMemberRecord(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeTroopMemberRecord successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeTroopMemberRecord with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeTroopMemberRecord.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeTroopMemberRecord(HeTroopMemberRecord model) throws AppException {
		heTroopMemberRecordDao.insertHeTroopMemberRecord(model);
		return Response.status(Response.Status.CREATED).entity("A new HeTroopMemberRecord has been created").build();
	}
	
	@POST
	@Path("updateHeTroopMemberRecord.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeTroopMemberRecord(HeTroopMemberRecord model) throws AppException {
		heTroopMemberRecordDao.updateHeTroopMemberRecord(model);
		return Response.status(Response.Status.CREATED).entity("A HeTroopMemberRecord has been updated").build();
	}
}
