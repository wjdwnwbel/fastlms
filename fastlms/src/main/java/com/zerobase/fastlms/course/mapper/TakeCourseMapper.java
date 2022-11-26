package com.zerobase.fastlms.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.dto.TakeCourseDto;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.model.TakeCourseParam;

@Mapper
public interface TakeCourseMapper {
	long selectListCount(TakeCourseParam parameter);
    List<TakeCourseDto> selectList(TakeCourseParam parameter);
    
    List<TakeCourseDto> selectListMyCourse(TakeCourseParam parameter);
}

