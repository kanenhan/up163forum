package com.hanmanyi.qq.main;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
	
	public static void main(String[] args){
//		String s1 = "r=%7B%22to%22%3A4090490752%2C%22face%22%3A381%2C%22content%22%3A%22%5B%5C%22123%5C%22%2C%5C%22%5C%5Cn%E3%80%90%E6%8F%90%E7%A4%BA%EF%BC%9A%E6%AD%A4%E7%94%A8%E6%88%B7%E6%AD%A3%E5%9C%A8%E4%BD%BF%E7%94%A8WebQQ%EF%BC%9Ahttp%3A%2F%2Fweb.qq.com%2F%E3%80%91%5C%22%2C%5B%5C%22font%5C%22%2C%7B%5C%22name%5C%22%3A%5C%22%E5%AE%8B%E4%BD%93%5C%22%2C%5C%22size%5C%22%3A%5C%2210%5C%22%2C%5C%22style%5C%22%3A%5B0%2C0%2C0%5D%2C%5C%22color%5C%22%3A%5C%22000000%5C%22%7D%5D%5D%22%2C%22msg_id%22%3A46360001%2C%22clientid%22%3A%2284636109%22%2C%22psessionid";
//		String s2 = "r=%7B%22to%22%3A4090490752%2C%22face%22%3A381%2C%22content%22%3A%22%5B%5C%22123%5C%22%2C%5C%22%5C%5Cn%E3%80%90%E6%8F%90%E7%A4%BA%EF%BC%9A%E6%AD%A4%E7%94%A8%E6%88%B7%E6%AD%A3%E5%9C%A8%E4%BD%BF%E7%94%A8WebQQ%EF%BC%9Ahttp%3A%2F%2Fweb.qq.com%2F%E3%80%91%5C%22%2C%5B%5C%22font%5C%22%2C%7B%5C%22name%5C%22%3A%5C%22%E5%AE%8B%E4%BD%93%5C%22%2C%5C%22size%5C%22%3A%5C%2210%5C%22%2C%5C%22style%5C%22%3A%5B0%2C0%2C0%5D%2C%5C%22color%5C%22%3A%5C%22000000%5C%22%7D%5D%5D%22%2C%22msg_id%22%3A73670001%2C%22clientid%22%3A%2258367687%22%2C%22psessionid";
//		
//		String ss1 = "", ss2 = "";
//		try {
//			ss1 = URLDecoder.decode(s1, "utf-8");
//			ss2 = URLDecoder.decode(s2, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(ss1.equals(ss2))
//			System.out.println("OK");
//		else{
//			for(int i=0; i<ss1.length(); i++){
//				if(ss1.charAt(i)!=ss2.charAt(i)){
//					System.out.println("Stop:"+i);
//					System.out.println(ss1.substring(i));
//					System.out.println(ss2.substring(i));
//					break;
//				}
//			}
//		}
		
		//GroupMessage
		String str = "r=%7B%22group_uin%22%3A3791146296%2C%22content%22%3A%22%5B%5C%22%E5%A4%A7%E5%AE%B6%E5%A5%BD%5C%22%2C%5C%22%5C%5Cn%E3%80%90%E6%8F%90%E7%A4%BA%EF%BC%9A%E6%AD%A4%E7%94%A8%E6%88%B7%E6%AD%A3%E5%9C%A8%E4%BD%BF%E7%94%A8WebQQ%EF%BC%9Ahttp%3A%2F%2Fweb.qq.com%2F%E3%80%91%5C%22%2C%5B%5C%22font%5C%22%2C%7B%5C%22name%5C%22%3A%5C%22%E5%AE%8B%E4%BD%93%5C%22%2C%5C%22size%5C%22%3A%5C%2210%5C%22%2C%5C%22style%5C%22%3A%5B0%2C0%2C0%5D%2C%5C%22color%5C%22%3A%5C%22000000%5C%22%7D%5D%5D%22%2C%22msg_id%22%3A14310001%2C%22clientid%22%3A%2267431843%22%2C%22psessionid%22%3A%228368046764001e636f6e6e7365727665725f77656271714031302e3132382e36362e3131320000788700000b39026e0400ed03c7596d0000000a403435524d4347536a316d000000284a02a556753ae5c5babe20abed784a1faff1cb7c2f023c43fc46e8ca7fa28cc090bbd126110522d2%22%7D&clientid=67431843&psessionid=8368046764001e636f6e6e7365727665725f77656271714031302e3132382e36362e3131320000788700000b39026e0400ed03c7596d0000000a403435524d4347536a316d000000284a02a556753ae5c5babe20abed784a1faff1cb7c2f023c43fc46e8ca7fa28cc090bbd126110522d2";
		
		try {
			System.out.println(URLDecoder.decode(str, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
