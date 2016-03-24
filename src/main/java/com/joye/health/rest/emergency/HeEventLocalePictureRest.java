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

import com.joye.health.dao.emergency.IHeEventLocalePictureDao;
import com.joye.health.error.AppException;
import com.joye.health.model.common.SuccessMsg;
import com.joye.health.model.emergency.HeEventLocalePicture;

@Component
@Path("yjzh")
public class HeEventLocalePictureRest {

	@Autowired
	private IHeEventLocalePictureDao heEventLocalePictureDao;

	@Path("queryHeEventLocalePicture.do")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessMsg<HeEventLocalePicture> queryRegHeEventLocalePicture() {
		List<HeEventLocalePicture> list = heEventLocalePictureDao.queryHeEventLocalePicture();
		SuccessMsg<HeEventLocalePicture> res = new SuccessMsg<HeEventLocalePicture>();
		res.setData(list);
		return res;
	}
	
	@DELETE
	@Path("deleteHeEventLocalePicture.do/{pk}")
	@Produces({ MediaType.TEXT_HTML })
	public Response deletePodcastById(@PathParam("pk") String pk) {
		if (heEventLocalePictureDao.deleteHeEventLocalePicture(pk) == 1) {
			return Response.status(Response.Status.NO_CONTENT)// 204
					.entity("HeEventLocalePicture successfully removed from database").build();
		} else {
			return Response.status(404).entity("HeEventLocalePicture with the id " + pk + " is not present in the database")
					.build();
		}
	}

	@PUT
	@Path("insertHeEventLocalePicture.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response insertHeEventLocalePicture(HeEventLocalePicture units) throws AppException {
		heEventLocalePictureDao.insertHeEventLocalePicture(units);
		return Response.status(Response.Status.CREATED).entity("A new HeEventLocalePicture has been created").build();
	}
	
	@POST
	@Path("updateHeEventLocalePicture.do")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response updateHeEventLocalePicture(HeEventLocalePicture units) throws AppException {
		heEventLocalePictureDao.updateHeEventLocalePicture(units);
		return Response.status(Response.Status.CREATED).entity("A HeEventLocalePicture has been updated").build();
	}

}
