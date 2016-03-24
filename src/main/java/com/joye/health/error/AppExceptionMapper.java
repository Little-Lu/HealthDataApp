package com.joye.health.error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.joye.health.model.common.ErrorMsg;

public class AppExceptionMapper implements ExceptionMapper<AppException> {

	@Override
	public Response toResponse(AppException ex) {
		return Response.status(ex.getCode()).entity(new ErrorMsg(ex)).type(MediaType.APPLICATION_JSON).build();
	}

}
