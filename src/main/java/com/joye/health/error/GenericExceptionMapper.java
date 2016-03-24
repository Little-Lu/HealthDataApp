package com.joye.health.error;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.joye.health.model.common.ErrorMsg;

public class GenericExceptionMapper  implements ExceptionMapper<Throwable>  {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMsg errorMsg = new ErrorMsg();
		setHttpStatus(ex,errorMsg);
		errorMsg.setMsg(ex.getMessage());
		return Response.status(errorMsg.getCode())
				.entity(errorMsg)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	private void setHttpStatus(Throwable ex, ErrorMsg errorMsg) {
		if(ex instanceof WebApplicationException ) { //NICE way to combine both of methods, say it in the blog 
			errorMsg.setCode(((WebApplicationException)ex).getResponse().getStatus());
		} else {
			errorMsg.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()); //defaults to internal server error 500
		}
	}

}
