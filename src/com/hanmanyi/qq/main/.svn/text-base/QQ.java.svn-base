package com.hanmanyi.qq.main;

import java.util.Map;

import com.hanmanyi.qq.util.ExtractGroupInfo;
import com.hanmanyi.qq.util.ExtractUserFromAllFreinds;
import com.hanmanyi.qq.util.HttpClient;
import com.hanmanyi.qq.util.SendMessage;

public class QQ {

	private static String QQNum = "2916368410";
	private static String QQPassword = "123456789";
	private static String checkIdUrl = "http://ptlogin2.qq.com/check?appid=1003903&uin=";
	private static String PersonalInfo = "";
	private static String AllFriend = "";
	
	public static void main(String[] args){
		
		String verifycode = GetCheck.get(QQNum);
		System.out.println("-----verifycode----");
		System.out.println(verifycode);
		System.out.println("-----firstLogin----");
		System.out.println(Login.login(QQNum, QQPassword, verifycode));
		System.out.println("-------CurrentCookies-----");
		System.out.println("Cookie:"+HttpClient.getCookie());
		System.out.println("------secondLogin-------");
		String result = LoginAgain.loginAgain() ;
		System.out.println("LoginAgain:"+result);
		System.out.println("-------CurrentCookies-----");
		System.out.println("Cookie:"+HttpClient.getCookie());
//		PersonalInfo = UserInfo.getUserInfo(QQNum,result);
//		System.out.println("------FriendInfo-------");
//		System.out.println("PersonalInfo:"+PersonalInfo);
//		AllFriend = FriendInfo.getFriendInfo(result);
//		System.out.println("AllFriend:"+AllFriend);
//		String id = ExtractUserFromAllFreinds.getUID(ExtractUserFromAllFreinds.extract(AllFriend));
//		System.out.println("id:"+id);;
		System.out.println("-------GroupInfo-------");
		String group = ExtractGroupInfo.getGroupInfo(result);
		Map<String, String> groupMap = ExtractGroupInfo.extractGroup(group);
		System.out.println("-------SendGroupMsg-------");
		//http://tj.qstatic.com/getlog?qqweb2=1506214893$contextmenu$contancts$person|1506214893$contextmenu$contancts$sendmsg&t=1306244347734
//		String url = "http://tj.qstatic.com/getlog?qqweb2=1506214893$contextmenu$contancts$person|1506214893$contextmenu$contancts$sendmsg&t=1306244347734";
//		HttpClient.get(url);
		for(String groupID : groupMap.keySet()){
			System.out.println("SendGroup:"+groupID + ":" +groupMap.get(groupID));
			SendMessage.sendToGroup(groupID, "123", result);
		}
		System.out.println("-------CurrentCookies-----");
		System.out.println("Cookie:"+HttpClient.getCookie());
	}
}
