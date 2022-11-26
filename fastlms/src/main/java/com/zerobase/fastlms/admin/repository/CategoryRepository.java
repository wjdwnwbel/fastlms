package com.zerobase.fastlms.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zerobase.fastlms.admin.entity.Category;
import com.zerobase.fastlms.member.entity.Member;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

