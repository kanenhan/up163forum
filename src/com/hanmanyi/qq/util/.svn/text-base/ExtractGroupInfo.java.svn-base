package com.hanmanyi.qq.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractGroupInfo {
	private static String groupURL = "http://s.web2.qq.com/api/get_group_name_list_mask2";
//r={"vfwebqq":"87e4f71a7a0e0f40732fbb51d70c971644bda4cae21fb787bc8fde18a0225344f5d4448a137de383"}	
	public static String getGroupInfo(String source){
		String result = "";
		String vfwebqq = FindValueAccordingKey.findValue("vfwebqq", source);
		String data = "{\"vfwebqq\":\"" + vfwebqq + "\"}";
		String postData = "";
		try {
			postData = URLEncoder.encode(data, "utf-8");
			postData = "r=" +postData;
			System.out.println("PostData:"+postData);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = HttpClient.post(groupURL, postData);
		
		return result;
	}
	
//"gid":906194297,"code":2059615935,"flag":16777217,"name":" \u98DE"	
	public static Map<String, String> extractGroup(String str){
		Map<String, String> groupMap = new HashMap<String, String>();
		String regex = "\"gid\":(.*?),(.*?),\"name\":\"(.*?)\"";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		
		while(m.find()){
			System.out.println(m.group(1)+":"+m.group(3));
			groupMap.put(m.group(1), m.group(3));
		}
		
		return groupMap;
	}
	
	public static void main(String[] args){
		String s = "{\"retcode\":0,\"result\":{\"gnamelist\":[{\"gid\":906194297,\"code\":2059615935,\"flag\":16777217,\"name\":\" \u98DE\"}],\"gmasklist\":[{\"gid\":1000,\"mask\":0}],\"gmarklist\":[]}}";
		extractGroup(s);
	}

}
