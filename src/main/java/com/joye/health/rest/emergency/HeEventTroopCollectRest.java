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

import com.joye.health.dao.emergency.IHeEventTroopCollectDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeEventTroopCollect;

@Component
@Path("yjzh")
public class HeEventTroopCollectRest {

	@Autowired
	private IHeEventTroopCollectDao heEventTroopCollectDao;

	@Path("queryHeEventTroopCollect.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeEventTroopCollect> queryRegHeEventTroopCollect() {
		List<HeEventTroopCollect> list = heEventTroopCollectDao.queryHeEventTroopCollect();
		SuccessMsg<HeEventTroopCollect> res = new SuccessMsg<HeEventTroopCollect>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeEventTroopCollect.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heEventTroopCollectDao.deleteHeEventTroopCollect(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeEventTroopCollect successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeEventTroopCollect with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeEventTroopCollect.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeEventTroopCollect(HeEventTroopCollect units) throws AppException {
		heEventTroopCollectDao.insertHeEventTroopCollect(units);
		return Response.status(Response.Status.CREATED).entity("A new HeEventTroopCollect has been created").build();
	}
	
	@POST
	@Path("updateHeEventTroopCollect.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeEventTroopCollect(HeEventTroopCollect units) throws AppException {
		heEventTroopCollectDao.updateHeEventTroopCollect(units);
		return Response.status(Response.Status.CREATED).entity("A HeEventTroopCollect has been updated").build();
	}

}
