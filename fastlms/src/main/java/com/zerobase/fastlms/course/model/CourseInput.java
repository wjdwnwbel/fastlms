package com.zerobase.fastlms.course.model;

import lombok.Data;

@Data
public class CourseInput {
	long id;
	long categoryId;
	String subject;
	String keyword;
	String summary;
	String contents;
	long price;
	long salePrice;
	String saleEndDtText;	// 날짜형을 잘 모르기때문에 String으로 받아서 날짜형으로 바ㅜ꺼서 처리
	
	// 삭제를 위한
	String idList;
	
	// 이미지 추가를 위한
    String filename;
    String urlFilename;
}
