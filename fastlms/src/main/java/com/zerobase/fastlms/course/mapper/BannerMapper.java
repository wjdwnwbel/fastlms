package com.zerobase.fastlms.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zerobase.fastlms.course.dto.BannerDto;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.dto.TakeCourseDto;
import com.zerobase.fastlms.course.entity.Banner;
import com.zerobase.fastlms.course.model.BannerParam;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.model.TakeCourseParam;

@Mapper
public interface BannerMapper {
	long selectListCount(BannerParam parameter);
    List<BannerDto> selectList(BannerParam parameter);
}

