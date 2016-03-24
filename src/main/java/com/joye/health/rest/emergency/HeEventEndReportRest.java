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

import com.joye.health.dao.emergency.IHeEventEndReportDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeEventEndReport;

@Component
@Path("yjzh")
public class HeEventEndReportRest {

	@Autowired
	private IHeEventEndReportDao heEventEndReportDao;

	@Path("queryHeEventEndReport.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeEventEndReport> queryRegHeEventEndReport() {
		List<HeEventEndReport> list = heEventEndReportDao.queryHeEventEndReport();
		SuccessMsg<HeEventEndReport> res = new SuccessMsg<HeEventEndReport>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeEventEndReport.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heEventEndReportDao.deleteHeEventEndReport(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeEventEndReport successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeEventEndReport with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeEventEndReport.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeEventEndReport(HeEventEndReport units) throws AppException {
		heEventEndReportDao.insertHeEventEndReport(units);
		return Response.status(Response.Status.CREATED).entity("A new HeEventEndReport has been created").build();
	}
	
	@POST
	@Path("updateHeEventEndReport.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeEventEndReport(HeEventEndReport units) throws AppException {
		heEventEndReportDao.updateHeEventEndReport(units);
		return Response.status(Response.Status.CREATED).entity("A HeEventEndReport has been updated").build();
	}


}
