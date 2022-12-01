package com.zerobase.fastlms.course.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zerobase.fastlms.course.dto.BannerDto;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.entity.Banner;
import com.zerobase.fastlms.course.model.BannerInput;
import com.zerobase.fastlms.course.model.BannerParam;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.service.BannerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminBannerController extends BaseController{
	private final BannerService bannerService;
	
	
	@GetMapping("/admin/banner/list.do")
	public String list(Model model, BannerParam parameter) {
		
		List<BannerDto> list = bannerService.list(parameter);
		
		long totalCount = 0;
		
		if(!CollectionUtils.isEmpty(list)) {
			totalCount = list.get(0).getTotalCount();
		}
		
		String queryString = parameter.getQueryString();
		String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);

		model.addAttribute("list", list);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pager", pagerHtml);
		
		return "admin/banner/list";
	}
	
	
	@GetMapping(value = {"/admin/banner/add.do", "/admin/banner/edit.do"})
	public String add(Model model, HttpServletRequest request, BannerParam parameter) {
		
		model.addAttribute("banner", bannerService.list());
		
		
		boolean editMode = request.getRequestURI().contains("/edit.do");
		BannerDto detail = new BannerDto();
		
		if(editMode) {
			long no = parameter.getNo();
			
			BannerDto existBanner = bannerService.getByNo(no);
			if(existBanner == null) {
				// 에러처리
				model.addAttribute("message", "강좌정보가 존재하지 않습니다.");
				return "common/error";
			}
			detail = existBanner;
		}
		
		
		model.addAttribute("editMode", editMode);
		model.addAttribute("detail", detail);
		
		return "admin/banner/add";
	}
	
	@PostMapping(value = {"/admin/banner/add.do", "/admin/banner/edit.do"})
	public String addSubmit(Model model, MultipartFile file, BannerInput parameter) {
		
		
		if(file != null) {
			String originalFilename = file.getOriginalFilename();
			
			String baseLocalPath = "/Users/dd/git/fastlms/fastlms/files/banner";
			
			
			try {
				file.transferTo(new File(baseLocalPath +"/"+ originalFilename));
				
				boolean result = bannerService.add(parameter, "/files/banner/"+ originalFilename);
			} catch (Exception e) {
				log.info(e.getMessage());
			}}
		
		
		
		return "redirect:/admin/banner/list.do";
	}
}
