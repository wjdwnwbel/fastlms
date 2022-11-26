package com.zerobase.fastlms.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.model.MemberParam;

@Mapper
public interface MemberMapper {
	long selectListCount(MemberParam parameter);
	List<MemberDto> selectList(MemberParam parameter);
}
