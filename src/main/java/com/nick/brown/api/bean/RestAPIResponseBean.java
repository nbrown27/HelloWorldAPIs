package com.nick.brown.api.bean;

public class RestAPIResponseBean {
	private String status;
	
	private String message;
	
	private Object data;

	@Override
	public String toString() {
		return "RestAPIResponseBean [status=" + status + ", message=" + message + ", data=" + data + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
