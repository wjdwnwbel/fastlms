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
public class Course {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
	
	long categoryId;
    
    String imagePath;
    String keyword;
    String subject;
    
    @Column(length = 1000)
    String summary;
    
    @Lob
    String contents;
    long price;
    long salePrice;
    LocalDate saleEndDt;
    
    LocalDateTime regDt;		// 강좌를 추가한 날짜
    LocalDateTime udtDt;		// 강좌를 수정한 날짜
    
    // 이미지 추가를 위한
    String filename;
    String urlFilename;
    
}
