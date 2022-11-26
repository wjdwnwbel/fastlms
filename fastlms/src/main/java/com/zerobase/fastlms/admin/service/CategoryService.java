package com.zerobase.fastlms.admin.service;

import java.util.List;

import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.admin.model.CategoryInput;

public interface CategoryService {
	List<CategoryDto> list();

    boolean add(String categoryName);

    boolean update(CategoryInput parameter);
 
    boolean del(long id);

    // (회원)프론트 카테고리 정보
    List<CategoryDto> frontList(CategoryDto parameter);
}
