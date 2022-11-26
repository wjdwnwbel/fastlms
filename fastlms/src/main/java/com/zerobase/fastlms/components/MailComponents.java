package com.zerobase.fastlms.components;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MailComponents {
	
	private final JavaMailSender javaMailSender;
	
	public void sendMatilTest() {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("wjdwnwbel@naver.com");
		msg.setSubject("안녕하세요");
		msg.setText("안녕하세 제로베이스 입니다.");
		
		javaMailSender.send(msg);
	}
	
	
	public boolean sendMail(String mail, String subject, String text) {
		
		boolean result = false;
		MimeMessagePreparator msg = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setTo(mail);
				messageHelper.setSubject(subject);
				messageHelper.setText(text, true);	// html 사용 여부
				
			}
		};
		
		try {
			javaMailSender.send(msg);
			result = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
}
