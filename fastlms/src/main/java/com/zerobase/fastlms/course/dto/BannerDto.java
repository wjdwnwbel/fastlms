package com.zerobase.fastlms.course.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BannerDto {
    Long no;
	
	String bannerName;
	String alterText;
	
	String linkAddr;
	
    String filename;
    String urlFilename;
    
    String target;
    int sortValue;
    boolean frontYn;
    LocalDateTime regDt;
	
    long totalCount;
    long seq;
}
