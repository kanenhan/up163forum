package com.hanmanyi.qq.main;

import java.util.Date;

import com.hanmanyi.qq.util.FindValueAccordingKey;
import com.hanmanyi.qq.util.HttpClient;

public class UserInfo {
	private static String userInfoURL = "http://s.web2.qq.com/api/get_friend_info2?";
	
	public static String getUserInfo(String QQ, String loginAgainResult){
	long time = new Date().getTime();
	String url = userInfoURL + "tuin="+ QQ + "&verifysession=&code=&vfwebqq="+ FindValueAccordingKey.findValue("vfwebqq", loginAgainResult)+"&t=" + time + "\"";
		
		String result = HttpClient.get(url);
		return result ;
	}

}
