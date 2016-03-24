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

import com.joye.health.dao.emergency.IHeEventPersonReportDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeEventPersonReport;

@Component
@Path("yjzh")
public class HeEventPersonReportRest {

	@Autowired
	private IHeEventPersonReportDao heEventPersonReportDao;

	@Path("queryHeEventPersonReport.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeEventPersonReport> queryRegHeEventPersonReport() {
		List<HeEventPersonReport> list = heEventPersonReportDao.queryHeEventPersonReport();
		SuccessMsg<HeEventPersonReport> res = new SuccessMsg<HeEventPersonReport>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeEventPersonReport.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heEventPersonReportDao.deleteHeEventPersonReport(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeEventPersonReport successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeEventPersonReport with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeEventPersonReport.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeEventPersonReport(HeEventPersonReport units) throws AppException {
		heEventPersonReportDao.insertHeEventPersonReport(units);
		return Response.status(Response.Status.CREATED).entity("A new HeEventPersonReport has been created").build();
	}
	
	@POST
	@Path("updateHeEventPersonReport.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeEventPersonReport(HeEventPersonReport units) throws AppException {
		heEventPersonReportDao.updateHeEventPersonReport(units);
		return Response.status(Response.Status.CREATED).entity("A HeEventPersonReport has been updated").build();
	}

}
