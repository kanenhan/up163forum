package com.hanmanyi.qq.main;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.hanmanyi.qq.util.HttpClient;

public class LoginAgain {

	private static String loginAgainURL = "http://d.web2.qq.com/channel/login2";
	private static String postData1 = "r={\"status\":\"online\",\"ptwebqq\":\"" ;
	private static String postData2	= "\",\"passwd_sig\":\"\",\"clientid\":\"19162296\",\"psessionid\":null}&clientid=19162296&psessionid=null";
	
	public static String loginAgain(){
		String str = "";
		String postData = postData1 + HttpClient.getValue("ptwebqq") + postData2 ;
		try {
			str = URLDecoder.decode(postData, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return HttpClient.post(loginAgainURL, str);
	}
	
}
