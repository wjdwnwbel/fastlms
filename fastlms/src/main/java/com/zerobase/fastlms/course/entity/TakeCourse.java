package com.zerobase.fastlms.course.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TakeCourse implements TakeCourseCode{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
	
	long courseId;
	String userId;
    
	long payPrice;			// 결제 금액
	String status;			// 수강신청, 결제완료, 수강취소
    
    
    LocalDateTime regDt;	// 신청 날짜 
    
}
