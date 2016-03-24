package com.joye.health.error;

public class AppException extends Exception {

	private static final long serialVersionUID = -1858788971146150373L;
	private String ver = "1.0";
	private int code;
	private String msg;

	public AppException(int code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}

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

}
