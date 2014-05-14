package com.hanmanyi.qq.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.hanmanyi.qq.util.HttpClient;
import com.hanmanyi.qq.util.QQMd5;

public class Login {
	
	private static String loginURL = "http://ptlogin2.qq.com/login?";
	private static Map<String, String> loginParams = new HashMap<String, String>();
	//http://ptlogin2.qq.com/login?
	//u=1506214893&
	//p=3882A2BCB819ACF5C3DF5AFBEA065493&
	//verifycode=!PCP&
	//webqq_type=10&
	//remember_uin=1&
	//login2qq=1&
	//aid=1003903&
	//u1=http%3A%2F%2Fweb.qq.com%2Floginproxy.html%3Flogin2qq%3D1%26webqq_type%3D10&
	//h=1&
	//ptredirect=0&
	//ptlang=2052&
	//from_ui=1&
	//pttype=1&
	//dumy=&
	//fp=loginerroralert&
	//mibao_css=m_webqq

	public static String login(String QQNum, String password, String verifycode){
		
		
		URL serverUrl;
		HttpURLConnection conn;
		StringBuffer res = new StringBuffer();
		String loginPass = QQMd5.mdP(password, verifycode);
		loginParams.put("u", QQNum);
		loginParams.put("p", loginPass);
		loginParams.put("verifycode", verifycode);
		loginParams.put("webqq_type", "10");
		loginParams.put("remember_uin", "1");
		loginParams.put("aid", "1003903");
		loginParams.put("u1", "http%3A%2F%2Fweb.qq.com%2Floginproxy.html%3Flogin2qq%3D1%26webqq_type%3D10");
		loginParams.put("h", "1");
		loginParams.put("ptredirect", "0");
		loginParams.put("ptlang", "2052");
		loginParams.put("from_ui", "1");
		loginParams.put("pttype", "1");
		loginParams.put("dumy", "");
		loginParams.put("fp", "loginerroralert");
		loginParams.put("mibao_css", "m_webqq");
		
		for(String key : loginParams.keySet()){
			loginURL = loginURL + key + "=" + loginParams.get(key) + "&";
		}
		
		loginURL = loginURL.substring(0, loginURL.length()-1);
//		System.out.println("LoginURL>>" + loginURL);
		
		return HttpClient.get(loginURL);
	}

}
