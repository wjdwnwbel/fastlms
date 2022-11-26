package com.zerobase.fastlms.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseParam;

@Mapper
public interface CourseMapper {
	long selectListCount(CourseParam parameter);
    List<CourseDto> selectList(CourseParam parameter);
}
