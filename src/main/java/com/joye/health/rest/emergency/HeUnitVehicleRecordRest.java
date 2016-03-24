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

import com.joye.health.dao.emergency.IHeUnitVehicleRecordDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeUnitVehicleRecord;

@Component
@Path("yjzh")
public class HeUnitVehicleRecordRest {

	@Autowired
	private IHeUnitVehicleRecordDao heUnitVehicleRecordDao;

	@Path("queryHeUnitVehicleRecord.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeUnitVehicleRecord> queryRegHeUnitVehicleRecord() {
		List<HeUnitVehicleRecord> list = heUnitVehicleRecordDao.queryHeUnitVehicleRecord();
		SuccessMsg<HeUnitVehicleRecord> res = new SuccessMsg<HeUnitVehicleRecord>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeUnitVehicleRecord.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heUnitVehicleRecordDao.deleteHeUnitVehicleRecord(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeUnitVehicleRecord successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeUnitVehicleRecord with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeUnitVehicleRecord.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeUnitVehicleRecord(HeUnitVehicleRecord model) throws AppException {
		heUnitVehicleRecordDao.insertHeUnitVehicleRecord(model);
		return Response.status(Response.Status.CREATED).entity("A new HeUnitVehicleRecord has been created").build();
	}
	
	@POST
	@Path("updateHeUnitVehicleRecord.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeUnitVehicleRecord(HeUnitVehicleRecord model) throws AppException {
		heUnitVehicleRecordDao.updateHeUnitVehicleRecord(model);
		return Response.status(Response.Status.CREATED).entity("A HeUnitVehicleRecord has been updated").build();
	}
}
