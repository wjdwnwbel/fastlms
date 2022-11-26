package com.zerobase.fastlms.common.model;

import lombok.Data;

@Data
public class ResponseResult {
	public ResponseResult(boolean result, String message) {
		header = new ResponseResultHeader(result, message);
	}
	
	public ResponseResult(boolean result) {
		header = new ResponseResultHeader(result);
	}
	
	ResponseResultHeader header;
	Object body;
}
