package com.hanmanyi.qq.main;
/*
 * GetCheck使用Get方法得到验证码
 * 目前仅实现ptui_checkVC为0，为1则需要进一步得到验证码
 * 若为1,则需要通过http://captcha.qq.com/getimage?aid=1003903&uin=347073&vc_type=95ab7db15e5ab17f50f25d33598259e83ccc098c4af2f8a4得到验证码图片
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hanmanyi.qq.util.HttpClient;
import com.hanmanyi.qq.util.VerifyCode;

public class GetCheck {

	//http://ptlogin2.qq.com/check?uin=1506214893&appid=1003903&r=0.8921880534798963
	private static String checkURL = "http://ptlogin2.qq.com/check?uin=";
	private static String checkType = "";
	private static String checkVC = "" ;
	//使用Get方法
	public static String get(String QQ) {

		String url = checkURL + QQ + "&appid=1003903&r=0.8921820384798963";
		String response = HttpClient.get(url);
		String typeRegex = "\\'[0-9]\\'";
		
		System.out.println("response:"+response);
		checkType = response.substring(response.indexOf("'")+1, response.indexOf("'")+2);
		System.out.println(checkType);
		if(checkType.equals("0")){
			response = response.substring(response.indexOf("!"));
			checkVC = response.substring(0, response.indexOf("'"));
		}else{
			System.out.println(">>需要手动输入啦!");
			checkVC = VerifyCode.getVerifyCode(QQ);
		}
		return checkVC ;
		
	}
	
	public static void main(String[] args){
		String response = "ptui_checkVC('0','!MK5')";
 		Matcher matcher ;
		//得到返回值的类型0或者1
		Pattern patternType = Pattern.compile("\\w");
		matcher = patternType.matcher(response);
		System.out.println("Mather:"+ matcher.group());
		Pattern patternCode = Pattern.compile("'!\\w{3}'");
		matcher = patternCode.matcher(response);
		System.out.println("Matcher:"+matcher.group());
	}

}
