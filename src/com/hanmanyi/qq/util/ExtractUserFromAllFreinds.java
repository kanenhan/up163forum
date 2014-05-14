package com.hanmanyi.qq.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//id\":(.*?),\"univs\":(.*?),\"country_id\":0,\"name\":\"(.*?)\"
//id":1,"univs" ...... "country_id":0,"name":"̨��"
//"uin":2578323317,"nick":"\u7A7A\u95F4\u673A\u5668\u4EBA"
//\"uin\":(.*?),\"nick\":\"(.*?)\"
public class ExtractUserFromAllFreinds {

	private static String regex = "\"uin\":(.*?),\"nick\":\"(.*?)\"";
	
//	public static Map<String, String> idAndNameMap = new HashMap<String, String>();
	
	public static Map<String, String> extract(String str){
		Map<String, String> result = new HashMap<String, String>();
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
//			System.out.println("ID:"+matcher.group(1)+",Name:"+matcher.group(2));
//			System.out.println(new String(matcher.group(2)));
			String s = new String(matcher.group(2)).toString();
			result.put(matcher.group(1), s);
		}
//		idAndNameMap.putAll(result);
		System.out.println(result);
		return result;
	}
	
	public static String getUIDAccName(String name, Map<String, String> idAndNameMap){
		String uid = "";
		
		System.out.println("Name:"+name);
		for(String key : idAndNameMap.keySet()){
			if(idAndNameMap.get(key).indexOf(name)!=-1){
				uid = key;
				break ;
			}
		}
		
		return uid;
	}
	
	public static String getUID(Map<String, String> idAndNameMap){
		String uid = "";
		String name = "\\u7F8A";
		
		for(String key : idAndNameMap.keySet()){
			if(idAndNameMap.get(key).indexOf(name)!=-1){
				System.out.println("OK");
				uid = key;
				break ;
			}
		}
		
		return uid;
	}
    
	public static void main(String[] args){
		String str = "categories\":0}],\"info\":[{\"uin\":2578323317,\"nick\":\"\u7A7A\u95F4\u673A\u5668\u4EBA\",\"face\":0,\"flag\":526},{\"uin\":4255003948,\"nick\":\"    \u266A \uFF37\uFF37\u7F8A\",\"face\":0,\"flag\":29884994}],\"marknames\":[]}}";
		System.out.println();
		System.out.println("UID"+getUID(extract(str)));
	}
}
