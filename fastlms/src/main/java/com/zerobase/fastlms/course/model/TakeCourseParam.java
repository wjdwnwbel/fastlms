package com.zerobase.fastlms.course.model;

import lombok.Data;

@Data
public class TakeCourseParam extends CommonParam{
	long id;
	String status;

	String userId;
	
	long searchCourseId;
}