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
	
	
	@GetMapping("/admin/banner/add.do")
	public String add(Model model, HttpServletRequest request, BannerParam parameter) {
		
		model.addAttribute("banner", bannerService.list());
		
		
		boolean editMode = request.getRequestURI().contains("/edit.do");
		BannerDto detail = new BannerDto();
		
		// 수정은 아직..
		if(editMode) {
			long id = parameter.getId();
			
		}
		
		
		model.addAttribute("editMode", editMode);
		model.addAttribute("detail", detail);
		
		return "admin/banner/add";
	}
	
	@PostMapping("/admin/banner/add.do")
	public String addSubmit(Model model, MultipartFile file, BannerInput parameter) {
		
		if(file != null) {
			String originalFilename = file.getOriginalFilename();
			
			String baseLocalPath = "/Users/dd/git/fastlms/fastlms/files/banner";
			
			
			try {
				file.transferTo(new File(baseLocalPath +"/"+ originalFilename));
			} catch (Exception e) {
				log.info(e.getMessage());
			}}
		
		boolean result = bannerService.add(parameter);
		
		
		return "redirect:/admin/banner/list.do";
	}
}
