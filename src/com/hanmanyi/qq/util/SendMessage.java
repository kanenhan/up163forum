package com.hanmanyi.qq.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class SendMessage {
	private static String MsgToFriendURL = "http://d.web2.qq.com/channel/send_msg2";
	private static String MsgToGroupURL = "http://d.web2.qq.com/channel/send_group_msg2";
	
	public static String sendMsgToFriend(String qq, String msg, String str){
	
		String result= "";
		String data = "{\"to\":" ;
		String postData = "";
		String psessionid = FindValueAccordingKey.findValue("psessionid", str);

		data = data + qq + ",\"face\":381,\"content\":\"[\\\"" + msg.toString() + "\\\",\\\"\\\\n����ʾ�����û�����ʹ��WebQQ��http://web.qq.com/��\\\"," + "[\\\"font\\\",{\\\"name\\\":\\\"����\\\",\\\"size\\\":\\\"10\\\",\\\"style\\\":[0,0,0],\\\"color\\\":\\\"000000\\\"}]]\",\"msg_id\":73670001,\"clientid\":\"84636109\",\"psessionid\":\"" + psessionid + "\"}&clientid=84636109" + "&psessionid=" +psessionid;

		try {
			postData = URLEncoder.encode(data, "utf-8");
			postData = "r=" +postData;
			System.out.println("PostData:"+postData);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = HttpClient.post1(MsgToFriendURL, postData);
		
		return result ;
	}
	
	public static String sendToGroup(String groupID, String msg, String str){
		String result = "";
		String data = "{\"group_uin\":" ;
		String postData = "";
		String psessionid = FindValueAccordingKey.findValue("psessionid", str);
		String cookie1= "";
		

		data = data + groupID + ",\"content\":\"[\\\"" + msg.toString() + "\\\",\\\"\\\\n����ʾ�����û�����ʹ��WebQQ��http://web.qq.com/��\\\"," + "[\\\"font\\\",{\\\"name\\\":\\\"����\\\",\\\"size\\\":\\\"10\\\",\\\"style\\\":[0,0,0],\\\"color\\\":\\\"000000\\\"}]]\",\"msg_id\":73670001,\"clientid\":\"84636109\",\"psessionid\":\"" + psessionid + "\"}&clientid=84636109" + "&psessionid=" +psessionid;
		try {
			postData = URLEncoder.encode(data, "utf-8");
			postData = "r=" +postData;
			System.out.println("PostData:"+postData);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = HttpClient.post1(MsgToGroupURL, postData);
		
		return result;
	}
	
	public static void main(String[] args){
		sendMsgToFriend("3631251222","���","");
	}
}
