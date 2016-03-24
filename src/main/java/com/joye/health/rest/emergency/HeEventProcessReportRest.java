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

import com.joye.health.dao.emergency.IHeEventProcessReportDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeEventProcessReport;

@Component
@Path("yjzh")
public class HeEventProcessReportRest {

	@Autowired
	private IHeEventProcessReportDao heEventProcessReportDao;

	@Path("queryHeEventProcessReport.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeEventProcessReport> queryRegHeEventProcessReport() {
		List<HeEventProcessReport> list = heEventProcessReportDao.queryHeEventProcessReport();
		SuccessMsg<HeEventProcessReport> res = new SuccessMsg<HeEventProcessReport>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeEventProcessReport.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heEventProcessReportDao.deleteHeEventProcessReport(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeEventProcessReport successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeEventProcessReport with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeEventProcessReport.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeEventProcessReport(HeEventProcessReport units) throws AppException {
		heEventProcessReportDao.insertHeEventProcessReport(units);
		return Response.status(Response.Status.CREATED).entity("A new HeEventProcessReport has been created").build();
	}
	
	@POST
	@Path("updateHeEventProcessReport.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeEventProcessReport(HeEventProcessReport units) throws AppException {
		heEventProcessReportDao.updateHeEventProcessReport(units);
		return Response.status(Response.Status.CREATED).entity("A HeEventProcessReport has been updated").build();
	}

}
