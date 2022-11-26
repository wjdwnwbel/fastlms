package com.zerobase.fastlms.course.model;

import lombok.Data;

@Data
public class ServiceResult {
	
	boolean result;
	String message;
	
	public ServiceResult(boolean result, String message) {
		this.result = result;
		this.message = message;
	}

	public ServiceResult(boolean result) {
		this.result = result;
	}

	public ServiceResult() {
		result = true;
	}
}
