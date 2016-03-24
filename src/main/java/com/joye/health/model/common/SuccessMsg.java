package com.joye.health.model.common;

import java.util.List;

import javax.ws.rs.core.Response;

public class SuccessMsg<T> {
	private String ver = "1.0";
	private int code;
	private String msg;
	private List<T> data;
	private int total = 0;
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
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public SuccessMsg(){
		this.msg="success";
		this.code = Response.Status.OK.getStatusCode();
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}
