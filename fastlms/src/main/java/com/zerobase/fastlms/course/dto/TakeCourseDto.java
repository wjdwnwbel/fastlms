package com.zerobase.fastlms.course.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.zerobase.fastlms.course.entity.TakeCourse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TakeCourseDto {
    Long id;
	
	long courseId;
	String userId;
    
	long payPrice;			// 결제 금액
	String status;			// 수강신청, 결제완료, 수강취소
    
    
    LocalDateTime regDt;	// 신청 날짜 
    
    // Join
    String userName;
    String phone;
    String subject;
    
    // 추가 컬럼
    long totalCount;
    long seq;
    
    
    // 날짜 포맷
    public String getRegDtText() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    	
    	return regDt != null ? regDt.format(formatter) : "";
    }


	public static TakeCourseDto of(TakeCourse x) {
		
		return TakeCourseDto.builder()
                .id(x.getId())
                .courseId(x.getCourseId())
                .userId(x.getUserId())
                .payPrice(x.getPayPrice())
                .status(x.getStatus())
                .regDt(x.getRegDt())
                .build();
				
	}
}
