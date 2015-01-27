package org.spring.panda.objects;

public class Response {
	private boolean code;
	private String message;

	public Response(boolean code, String message) {
		this.code = code;
		this.message = message;
	}

	public boolean isCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
