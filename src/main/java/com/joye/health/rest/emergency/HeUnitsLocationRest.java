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

import com.joye.health.dao.emergency.IHeUnitsLocationDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeUnitsLocation;

@Component
@Path("yjzh")
public class HeUnitsLocationRest {

	@Autowired
	private IHeUnitsLocationDao heUnitsLocationDao;

	@Path("queryHeUnitsLocation.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeUnitsLocation> queryRegHeUnitsLocation() {
		List<HeUnitsLocation> list = heUnitsLocationDao.queryHeUnitsLocation();
		SuccessMsg<HeUnitsLocation> res = new SuccessMsg<HeUnitsLocation>();
		res.setData(list);
		return res;
	}

	@DELETE
	@Path("deleteHeUnitsLocation.do/{code}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("code") String code) {
		if (heUnitsLocationDao.deleteHeUnitsLocation(code) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("UNITS_LOCATION successfully removed from database").build();
		} else {
			return Response.status(404).entity("UNITS_LOCATION with the id " + code + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeUnitsLocation.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeUnitsLocation(HeUnitsLocation units) throws AppException {
		heUnitsLocationDao.insertHeUnitsLocation(units);
		return Response.status(Response.Status.CREATED).entity("A new units location has been created").build();
	}
	
	@POST
	@Path("updateHeUnitsLocation.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeUnitsLocation(HeUnitsLocation units) throws AppException {
		heUnitsLocationDao.updateHeUnitsLocation(units);
		return Response.status(Response.Status.CREATED).entity("A units location has been updated").build();
	}

}
