package com.joye.health.model.common;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import com.joye.health.error.AppException;

public class ErrorMsg {
	private String ver = "1.0";
	private int code;
	private String msg;

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ErrorMsg() {
	}

	public ErrorMsg(NotFoundException ex) {
		this.code = Response.Status.NOT_FOUND.getStatusCode();
		this.msg = ex.getMessage();
	}
	
	public ErrorMsg(AppException ex){
		this.code = ex.getCode();
		this.msg = ex.getMsg();
	}

}
