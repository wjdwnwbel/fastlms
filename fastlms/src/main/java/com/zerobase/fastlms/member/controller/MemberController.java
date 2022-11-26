package com.zerobase.fastlms.member.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.course.dto.TakeCourseDto;
import com.zerobase.fastlms.course.model.ServiceResult;
import com.zerobase.fastlms.course.service.TakeCourseService;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.HistoryInput;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.model.ResetPasswordInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import com.zerobase.fastlms.util.PasswordUtils;
import com.zerobase.fastlms.util.RequestUtils;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MemberController {
	
	// 요즘은 autowired를 쓰지않고 생성자를 통해 주입받는 방식을 사용
	private final MemberService memberService;
	private final TakeCourseService takeCourseService;
	
	
	@RequestMapping("/member/login")
	public String login() {
		
		return "member/login";
	}
	
	@PostMapping("/member/history")
	public String history(HttpServletRequest request) {
		
		String userAgent = RequestUtils.getUserAgent(request);
		String clientIp = RequestUtils.getClientIP(request);
		
		String userId = request.getParameter("username");
		boolean result = memberService.addLoginData(userId, userAgent, clientIp);
		
		return "redirect:/";
	}
	
	@GetMapping("/member/find/password")
	public String findPassword() {
		return "member/find_password";
	}
	@PostMapping("/member/find/password")
	public String findPasswordSubmit(Model model, HttpServletRequest request,
			ResetPasswordInput parameter) {
		boolean result = false;
		
		try {
			result = memberService.sendResetPassword(parameter);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("result", result);
		
		return "member/find_password_result";
	}
	
	
	@GetMapping("/member/register")
	public String register() {
		
		return "member/register";
	}
	@PostMapping("/member/register")
	public String registerSubmit(Model model, HttpServletRequest request,
			MemberInput parameter) {
		
		boolean result = memberService.register(parameter);
		model.addAttribute("result", result);
		
		return "member/register_complete";
	}
	
	
	
	@GetMapping("/member/email-auth")
	public String emailAuth(Model model, HttpServletRequest request) {
		String uuid = request.getParameter("id");
		System.out.println(uuid);
		
		boolean result = memberService.emailAuth(uuid);
		model.addAttribute("result", result);
		
		return "member/email_auth";
	}
	
	
	@GetMapping("/member/info")
	public String memberInfo(Principal principal, Model model) {
		
		String userId = principal.getName();
		
		MemberDto detail = memberService.detatil(userId);
		
		model.addAttribute("detail", detail);
		
		
		return "member/info";
	}
	@PostMapping("/member/info")
	public String memberInfoSubmit(Principal principal, MemberInput parameter,Model model) {
		
		String userId = principal.getName();
		parameter.setUserId(userId);
		
		ServiceResult result = memberService.updateMember(parameter);
		if(!result.isResult()) {
			model.addAttribute("message", result.getMessage());
			return "common/error";
		}
		
		return "redirect:/member/info";
	}
	
	
	@GetMapping("/member/password")
	public String memberPassword(Principal principal, Model model) {
		
		String userId = principal.getName();
		
		MemberDto detail = memberService.detatil(userId);
		
		model.addAttribute("detail", detail);
		
		return "member/password";
	}
	@PostMapping("/member/password")
	public String memberPasswordSubmit(Principal principal, MemberInput parameter, Model model) {
		
		String userId = principal.getName();
		parameter.setUserId(userId);
		
		ServiceResult result = memberService.updateMemberPassword(parameter);
		if(!result.isResult()) {
			model.addAttribute("message", result.getMessage());
			return "common/error";
		}
		
		model.addAttribute("result", result);
		
		return "redirect:/member/info";
	}
	
	
	@GetMapping("/member/takecourse")
	public String memberTakeCourse(Principal principal, Model model) {
		
		String userId = principal.getName();
		
		List<TakeCourseDto> list = takeCourseService.myCourse(userId);
		
		model.addAttribute("list", list);
		
		return "member/takecourse";
	}

	
	
	@GetMapping("/member/reset/password")
	private String resetPassword(Model model, HttpServletRequest request) {
		String uuid = request.getParameter("id");
		
		//uuid가 유효한지 확인
		boolean result = memberService.checkResetPassword(uuid);
		
		model.addAttribute("result", result);
		
		return "member/reset_password";
	}
	@PostMapping("/member/reset/password")
	public String resetPasswordSubmit(Model model, ResetPasswordInput parameter) {	
		
		boolean result = false;
		try {
			result = memberService.resetPassword(parameter.getId(), parameter.getPassword());
		} catch (Exception e) {
			
		}
		
		model.addAttribute("result", result);
		
		return "member/reset_password_result";
	}
	
	
	@GetMapping("/member/withdraw")
	public String memberWithdraw(Model model) {
		return "member/withdraw";
	}
	@PostMapping("/member/withdraw")
	public String memberWithdrawSubmit(Model model, Principal principal, MemberInput parameter) {
		
		String userId = principal.getName();
		parameter.setUserId(userId);
		
		ServiceResult result = memberService.withdraw(userId, parameter.getPassword());
		if(!result.isResult()) {
			model.addAttribute("message", result.getMessage());
			return "common/error";
		}
		
		
		return "redirect:/member/logout";
	}
}
