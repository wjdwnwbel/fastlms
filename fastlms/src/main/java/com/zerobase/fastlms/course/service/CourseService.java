package com.zerobase.fastlms.course.service;

import java.util.List;

import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseInput;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.model.ServiceResult;
import com.zerobase.fastlms.course.model.TakeCourseInput;

public interface CourseService {
	// 강좌 등록
	boolean add(CourseInput parameter);
	
	// 강좌 정보 수정
	boolean set(CourseInput parameter);
	
	// 강좌 목록
	List<CourseDto> list(CourseParam courseParam);

	// 강좌 상세 정보
	CourseDto getById(long id);

	// 강좌 내용 삭제
	boolean del(String idList);

	
	// 프론트 강좌 목록
	List<CourseDto> frontList(CourseParam courseParam);

	// 프론트에서 강좌 상세 정보 가져오기
	CourseDto frontDetail(long id);

	// 수강 신청
	ServiceResult req(TakeCourseInput parameter);

	
	// 전체 강좌 목록
	List<CourseDto> listAll();

	
}
