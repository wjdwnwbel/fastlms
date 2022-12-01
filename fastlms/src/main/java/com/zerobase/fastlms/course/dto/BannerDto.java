package com.zerobase.fastlms.course.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.course.entity.Banner;
import com.zerobase.fastlms.course.entity.Course;
import com.zerobase.fastlms.member.entity.Member;

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

    String filename;
    String urlFilename;
    
    String target;
    int sortValue;
    boolean frontYn;
    LocalDateTime regDt;
	
    long totalCount;
    long seq;
    
    public static BannerDto of(Banner banner) {
    	
    	return BannerDto.builder()
    			.alterText(banner.getAlterText())
    			.bannerName(banner.getBannerName())
    			.filename(banner.getFilename())
    			.frontYn(banner.getFrontYn())
    			.urlFilename(banner.getUrlFilename())
    			.target(banner.getTarget())
    			.sortValue(banner.getSortValue())
    			.build();
	}
}
