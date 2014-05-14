package com.hanmanyi.qq.main;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.hanmanyi.qq.util.FindValueAccordingKey;
import com.hanmanyi.qq.util.HttpClient;

public class FriendInfo {

	private static String url = "http://s.web2.qq.com/api/get_user_friends2";
	
	public static String getFriendInfo(String loginAgainResult){
		String result = "";
//r={"h":"hello","vfwebqq":"+--+ "}

		String str = "r={\"h\":\"hello\",\"vfwebqq\":\""+ FindValueAccordingKey.findValue("vfwebqq", loginAgainResult) +"\"}" ;
		String postData = "";
		try {
			postData = URLDecoder.decode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = HttpClient.post(url, postData);
		
		return result ;
	}
}
