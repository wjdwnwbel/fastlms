package com.zerobase.fastlms.admin.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.zerobase.fastlms.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
	String userId;
	String userName;
	String phone;
	String password;
	LocalDateTime regDt;
	LocalDateTime udtDt;
	
	LocalDateTime emailAuthDt;	
	boolean emailAuthYn;		
	String emailAuthKey;		
	
	String resetPasswordKey;	
	LocalDateTime resetPasswordLimitDt;	
	
	
	boolean adminYn;
	

	long totalCount;	// 추가 컬럼
	long seq;			// 번호 계산하기 위한 필드
	
	String userStatus;
	
	String zipcode;	
	String addr;	
	String addrDetail;	
	
	Date loginDate; // 마지막 로그인 날짜
	
	
	public static MemberDto of(Member member) {
		return MemberDto.builder()
				.userId(member.getUserId())
				.userName(member.getUserName())
				.phone(member.getPhone())
				.regDt(member.getRegDt())
				.udtDt(member.getUdtDt())
				.emailAuthYn(member.isEmailAuthYn())
				.emailAuthDt(member.getEmailAuthDt())
				.emailAuthKey(member.getEmailAuthKey())
				
				.resetPasswordKey(member.getResetPasswordKey())
				.resetPasswordLimitDt(member.getResetPasswordLimitDt())
				
				.adminYn(member.isAdminYn())
				.userStatus(member.getUserStatus())
				
				.zipcode(member.getZipcode())
				.addr(member.getAddr())
				.addrDetail(member.getAddrDetail())
				.build();
	}
	
	// 날짜 포맷
    public String getRegDtText() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
    	
    	return regDt != null ? regDt.format(formatter) : "";
    }
    
    public String getUdtDtText() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
    	
    	return udtDt != null ? udtDt.format(formatter) : "";
    }
    

}
