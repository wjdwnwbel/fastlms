package com.zerobase.fastlms.configuration;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.zerobase.fastlms.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	private final MemberService memberService;
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserAuthenticationFailureHandler getFailureHandler() {
		return new UserAuthenticationFailureHandler();
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		
		
		// 로그인 안해도 허락한 주소에 대하여 접근 가능
		http.authorizeRequests().antMatchers("/", "/member/register"
				,"/member/email-auth", "/member/find/password"
				,"/member/reset/password")
		.permitAll();
		
		// 관리자 역할에서만 접근 가능
		http.authorizeHttpRequests().antMatchers("/admin/**")
		.hasAuthority("ROLE_ADMIN");
		/*
		.anyRequest()
		.hasAnyAuthority("ROLE_ADMIN", "ROLE_USER");
		*/
		
		// 로그인 페이지 설정
		// failureHandler는 실패하였을 때를 처리하는 핸들러
		http.formLogin()
		.loginPage("/member/login")
		.successForwardUrl("/member/history")
		.failureHandler(getFailureHandler())
		.permitAll();
		
		// 로그아웃 페이지 설정
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
		.logoutSuccessUrl("/").invalidateHttpSession(true);
		
		
		// 권한에 대한 예외 페이지 설정
		http.exceptionHandling().accessDeniedPage("/error/denied");
		
//		super.configure(http);
	}
	
	
	// 유저 정보 넘겨주는 것,
	// Authentic configuration을 할때 memberService가 인터페이스를 가지고 있어야함
	// userDetailsService는 UserDetailService를 상속 받아야하는 부분이 있으므로
	// 만든 MemberService에 스프링이 원하는 부분을 구현해주어야함
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService).passwordEncoder(getPasswordEncoder());
//		super.configure(auth);
	}

	
	
	// 이미지를 넣기 위해 경로 허용
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers("/favicon.ico", "/files/**", "/fastlms/files/**");
		
//		super.configure(web);
	}
	
}
