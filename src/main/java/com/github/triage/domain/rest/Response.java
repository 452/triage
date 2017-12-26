package com.github.triage.domain.rest;

public class Response {

	private Object data;

	public Response() {

	}

	public Response(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}