package com.zerobase.fastlms.course.service;

import java.util.List;

import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.course.dto.BannerDto;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.dto.TakeCourseDto;
import com.zerobase.fastlms.course.entity.Banner;
import com.zerobase.fastlms.course.model.BannerInput;
import com.zerobase.fastlms.course.model.BannerParam;
import com.zerobase.fastlms.course.model.CourseInput;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.model.ServiceResult;
import com.zerobase.fastlms.course.model.TakeCourseInput;
import com.zerobase.fastlms.course.model.TakeCourseParam;

public interface BannerService {
	List<Banner> list();
	// 배너 목록
	List<BannerDto> list(BannerParam parameter);
	boolean add(BannerInput parameter, String urlFilename);
	BannerDto getByNo(long id);
}
