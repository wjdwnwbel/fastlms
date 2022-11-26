package com.zerobase.fastlms.member.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.model.MemberParam;
import com.zerobase.fastlms.course.model.ServiceResult;
import com.zerobase.fastlms.member.entity.LoginHistory;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.HistoryInput;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.model.ResetPasswordInput;

public interface MemberService extends UserDetailsService{
	
	boolean register(MemberInput parameter);
	
	// uuid에 해당하는 계정 활성화
	boolean emailAuth(String uuid);

	// 입력한 이메일로 비밀번호 초기화 정보를 전송
	boolean sendResetPassword(ResetPasswordInput parameter);

	// 입력받은 uuid에 대해서 password로 초기화
	boolean resetPassword(String uuid, String password);

	
	// 입력받은 uuid 값이 유요한지 확인
	boolean checkResetPassword(String uuid);
	
	
	// 모든 회원 정보 가져오기
	List<MemberDto> list(MemberParam parameter);

	// 회원 상세 정보 가져오기
	MemberDto detatil(String userId);
	
	// 회원 상태 변경
	boolean updateStatus(String userId, String userStatus);
	
	// 회원 비밀번호 초기화(메일)
	boolean updatePassword(String userId, String password);
	
	// 회원 비밀번호 수정(회원 정보 페이지)
	ServiceResult updateMemberPassword(MemberInput parameter);
	
	// 회원 정보 수정
	ServiceResult updateMember(MemberInput parameter);

	// 회원 탈퇴
	ServiceResult withdraw(String userId, String password);

	// 접속 기록 추가
	boolean addLoginData(String userId, String userAgent, String clientIp);

	// 해당하는 로그인 기록 가져오기
	List<LoginHistory> gethistory(String userId);

}
