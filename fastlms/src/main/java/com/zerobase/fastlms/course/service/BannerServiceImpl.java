package com.zerobase.fastlms.course.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.entity.Category;
import com.zerobase.fastlms.course.dto.BannerDto;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.dto.TakeCourseDto;
import com.zerobase.fastlms.course.entity.Banner;
import com.zerobase.fastlms.course.entity.Course;
import com.zerobase.fastlms.course.entity.TakeCourse;
import com.zerobase.fastlms.course.entity.TakeCourseCode;
import com.zerobase.fastlms.course.mapper.BannerMapper;
import com.zerobase.fastlms.course.mapper.CourseMapper;
import com.zerobase.fastlms.course.mapper.TakeCourseMapper;
import com.zerobase.fastlms.course.model.BannerInput;
import com.zerobase.fastlms.course.model.BannerParam;
import com.zerobase.fastlms.course.model.CourseInput;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.model.ServiceResult;
import com.zerobase.fastlms.course.model.TakeCourseInput;
import com.zerobase.fastlms.course.model.TakeCourseParam;
import com.zerobase.fastlms.course.repository.BannerRepository;
import com.zerobase.fastlms.course.repository.CourseRepository;
import com.zerobase.fastlms.course.repository.TakeCourseRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService{
	private final BannerMapper bannerMapper;
	private final BannerRepository bannerRepository;

	@Override
	public List<BannerDto> list(BannerParam parameter) {
		
		long totalCount = bannerMapper.selectListCount(parameter);
		
		List<BannerDto> list = bannerMapper.selectList(parameter);
		
		if(!CollectionUtils.isEmpty(list)) {
			int i = 0;
			for(BannerDto x:list) {
				x.setTotalCount(totalCount);		
				x.setSeq(totalCount - parameter.getPageStart() -i);
				i++;
			}
		}
		
		
		return list;
		
	}

	@Override
	public List<Banner> list() {
		List<Banner> banners = bannerRepository.findAll();
		
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
//		for(Banner b : banners) {
//			b.setRegDt(LocalDateTime.now().format(formatter));
//		}
		
        return banners;
	}

	@Override
	public boolean add(BannerInput parameter, String urlFilename) {
		
		Banner banner = Banner.builder()
				.bannerName(parameter.getBannerName())
				.alterText("대체 이미지 입니다.")
				.filename(urlFilename)
				.urlFilename(parameter.getUrlFilename())
				.target(parameter.getTarget())
				.sortValue(parameter.getSortValue())
				.regDt(LocalDateTime.now())
				.frontYn(true)
				.build();
		
		bannerRepository.save(banner);
		
		return true;
	}

	@Override
	public BannerDto getByNo(long no) {
		
		return bannerRepository.findByNo(no).map(BannerDto::of).orElse(null);
	} 

	
	
}
