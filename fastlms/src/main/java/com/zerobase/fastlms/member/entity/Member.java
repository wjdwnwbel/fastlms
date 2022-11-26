package com.zerobase.fastlms.member.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Member implements MemberCode{
	
	@Id
	private String userId;
	private String userName;
	private String phone;
	private String password;
	private LocalDateTime regDt;		// 가입 날짜
	private LocalDateTime udtDt;		// 회원 정보 수정일
	
	private LocalDateTime emailAuthDt;	// 이메일 인증날짜
	private boolean emailAuthYn;		// 이메일 인증 여부
	private String emailAuthKey;		// 이메일 인증 키
	
	private String resetPasswordKey;	// 비밀번호 초기화 키
	private LocalDateTime resetPasswordLimitDt;	// 비밀번호 초기화 가능한 시간
	
	
	private boolean adminYn;			// 관리자 구분
	private String userStatus;			// 회원 상태 : 이용가능한 상태, 정지 상태
	
	private String zipcode;				// 우편번호 실행 코드
	private String addr;				// 주소
	private String addrDetail;			// 상세 주소\
	
}
