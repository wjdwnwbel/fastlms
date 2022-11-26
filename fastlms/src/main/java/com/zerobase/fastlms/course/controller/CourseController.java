package com.zerobase.fastlms.course.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.service.CategoryService;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseInput;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.service.CourseService;
import com.zerobase.fastlms.util.PageUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CourseController extends BaseController{
	private final CourseService courseService;
	private final CategoryService categoryService;
	
	@GetMapping("/course")
    public String course(Model model, CourseParam parameter) {
		
        List<CourseDto> list = courseService.frontList(parameter);
        model.addAttribute("list", list);
        
        
        List<CategoryDto> categoryList = categoryService.frontList(CategoryDto.builder().build());
        model.addAttribute("categoryList", categoryList);
        
        int courseTotalCount = 0;
        if(categoryList != null) {
        	for(CategoryDto x : categoryList) {
        		courseTotalCount += x.getCourseCount();
        	}
        }
        model.addAttribute("courseTotalCount", courseTotalCount);
        
        return "course/index";
    }
	
	@GetMapping("/course/{id}")
	public String courseDetail(Model model, CourseParam parameter) {
		
		CourseDto detail = courseService.frontDetail(parameter.getId());
		model.addAttribute("detail", detail);
		
		return "course/detail";
	}
	
}
