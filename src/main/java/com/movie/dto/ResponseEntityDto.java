package com.movie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author puriSidharth
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseEntityDto {
 
	
	private int code;
	private String status;
	private String message;
	private Object result;
	
	
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	public ResponseEntityDto() {
	}

	/**
	 * @param code
	 * @param status
	 * @param message
	 */
	public ResponseEntityDto(int code, String status, String message) {
		this.code = code;
		this.status = status;
		this.message = message;
	}    
	
	
	public ResponseEntityDto(int code, String status, String message, Object result) {
		this.code = code;
		this.status = status;
		this.message = message;
		this.result = result;
	}
}
