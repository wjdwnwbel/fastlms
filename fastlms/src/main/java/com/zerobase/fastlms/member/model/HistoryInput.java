package com.zerobase.fastlms.member.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class HistoryInput {
	private String userId;
	private String userAgent;
	private String clientIp;
}
