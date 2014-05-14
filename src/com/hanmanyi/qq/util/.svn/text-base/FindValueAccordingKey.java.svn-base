package com.hanmanyi.qq.util;
public class FindValueAccordingKey {

	//Ŀǰ��Ϊ�˴�source�ҵ�vfwebqq�õ��û�����
	public static String findValue(String key, String source){
		String value = "";
		String str = source.substring(source.indexOf(key));
		
		str = str.substring(str.indexOf("\"")+3);
		
		value = str.substring(0, str.indexOf("\""));
		return value ;
	}
	
	public static void main(String[] args){
		String str = "{\"retcode\":0,\"result\":{\"uin\"online\",\"vfwebqq\":\"18941f1b23ba18a14e9f95260f5c8f1edbcc6a745ae1ec1a2c16af27b0744e7aed4a4e9f4bfa7102\",\"psessionid\":\"";
		
		System.out.println(findValue("vfwebqq", str));
	}
}
