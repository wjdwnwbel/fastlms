package com.zerobase.fastlms.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zerobase.fastlms.member.entity.LoginHistory;

public interface HistoryRepository extends JpaRepository<LoginHistory, String>{
	Optional<List<LoginHistory>> findByLoginIdOrderByNoDesc(String loginId);
}
