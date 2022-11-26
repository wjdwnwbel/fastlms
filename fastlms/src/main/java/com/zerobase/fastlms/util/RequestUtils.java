package com.zerobase.fastlms.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
	
	public static String getUserAgent(HttpServletRequest request) {
		String userAgent = request.getHeader("USER-AGENT");		

		
		return userAgent;
	}
	
	public static String getClientIP(HttpServletRequest request) {
		String clientIp = request.getHeader("X-FORWARDED-FOR"); 

        if (clientIp == null || clientIp.length() == 0) {
        	clientIp = request.getHeader("Proxy-Client-IP");
        }

        //웹로직 서버일 경우
        if (clientIp == null || clientIp.length() == 0) {
        	clientIp = request.getHeader("WL-Proxy-Client-IP");
        }

        if (clientIp == null || clientIp.length() == 0) {
        	clientIp = request.getRemoteAddr() ;
        }
        
        return clientIp;
	}
}
