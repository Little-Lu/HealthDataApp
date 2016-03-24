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

import com.joye.health.dao.emergency.IHeEventFirstReportDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeEventFirstReport;

@Component
@Path("yjzh")
public class HeEventFirstReportRest {

	@Autowired
	private IHeEventFirstReportDao heEventFirstReportDao;

	@Path("queryHeEventFirstReport.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeEventFirstReport> queryRegHeEventFirstReport() {
		List<HeEventFirstReport> list = heEventFirstReportDao.queryHeEventFirstReport();
		SuccessMsg<HeEventFirstReport> res = new SuccessMsg<HeEventFirstReport>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeEventFirstReport.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heEventFirstReportDao.deleteHeEventFirstReport(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeEventFirstReport successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeEventFirstReport with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeEventFirstReport.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeEventFirstReport(HeEventFirstReport units) throws AppException {
		heEventFirstReportDao.insertHeEventFirstReport(units);
		return Response.status(Response.Status.CREATED).entity("A new HeEventFirstReport has been created").build();
	}
	
	@POST
	@Path("updateHeEventFirstReport.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeEventFirstReport(HeEventFirstReport units) throws AppException {
		heEventFirstReportDao.updateHeEventFirstReport(units);
		return Response.status(Response.Status.CREATED).entity("A HeEventFirstReport has been updated").build();
	}

}
