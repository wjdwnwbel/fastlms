package com.zerobase.fastlms.member.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long no;
	
	String loginId;
	LocalDateTime loginDate;
	String clientIp;
	String userAgent;
	
}
