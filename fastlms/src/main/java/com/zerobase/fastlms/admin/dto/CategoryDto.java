package com.zerobase.fastlms.admin.dto;

import java.util.ArrayList;
import java.util.List;

import com.zerobase.fastlms.admin.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
	private Long id;
	
	String categoryName;
	int sortValue;
	boolean usingYn;
	
	// 추가 컬럼
	int courseCount;
	
	public static List<CategoryDto> of(List<Category> categories) {
        if (categories != null) {
            List<CategoryDto> categoryList = new ArrayList<>();
            for(Category x : categories) {
                categoryList.add(of(x));
            }
            return categoryList;
        }
        
        return null;
    }
    
    public static CategoryDto of(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .sortValue(category.getSortValue())
                .usingYn(category.isUsingYn())
                .build();
    }
}
