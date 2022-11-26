package com.zerobase.fastlms.course.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.zerobase.fastlms.course.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
	Long id;
    Long categoryId;
	
    String imagePath;
    String keyword;
    String subject;
    
    String summary;
    
    String contents;
    long price;
    long salePrice;
    LocalDate saleEndDt;
    
    LocalDateTime regDt;		// 강좌를 추가한 날짜
    LocalDateTime udtDt;	
    
    String filename;
    String urlFilename;
    
	long totalCount;
	long seq;
	

	
	public static CourseDto of(Course course) {
		
		return CourseDto.builder()
				.id(course.getId())
				.categoryId(course.getCategoryId())
				.imagePath(course.getImagePath())
				.keyword(course.getKeyword())
				.subject(course.getSubject())
				.summary(course.getSummary())
				.contents(course.getContents())
				.price(course.getPrice())
				.salePrice(course.getSalePrice())
				.saleEndDt(course.getSaleEndDt())
				.regDt(course.getRegDt())
				.udtDt(course.getUdtDt())
				.filename(course.getFilename())
				.urlFilename(course.getUrlFilename())
				.build();
	}

	public static List<CourseDto> of(List<Course> courses) {

		if(courses == null) {
			return null;
		}
		
		List<CourseDto> courseList = new ArrayList<>();
		for(Course x : courses) {
			courseList.add(CourseDto.of(x));
		}
	
		return courseList;
		
		/*
		if(courses != null) {
			List<CourseDto> courseList = new ArrayList<>();
			for(Course x : courses) {
				courseList.add(CourseDto.of(x));
			}
		
			return courseList;
		}
		
		return null;
		*/
	}
}
