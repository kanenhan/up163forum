package com.hanmanyi.qq.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {
	
	private static String refer = "http://d.web2.qq.com/proxy.html?v=20110331002&callback=2";
	//pgv_pvid=3474320336; pgv_info=pgvReferrer=&ssid=s8762989159; ptui_width=360; ptui_height=187
	private static String cookie = "";

	public static String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	
	public static String get(String url) {

		System.out.println("get>>>" + url);
		URL serverUrl;
		HttpURLConnection conn;
		StringBuffer res = new StringBuffer();
		try {
			serverUrl = new URL(url);
			conn = (HttpURLConnection) serverUrl.openConnection();
			conn.setRequestMethod("GET");// "POST" ,"GET"
			conn.addRequestProperty("Cookie", cookie);
			conn.addRequestProperty("Accept-Charset", "UTF-8;");// GB2312,
			conn.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
			conn.connect();

			if (conn.getHeaderFields().get("Set-Cookie") != null) {
				for (String s : conn.getHeaderFields().get("Set-Cookie")) {
					cookie += s;
				}
			}
			InputStream ins = conn.getInputStream();

			String charset = "UTF-8";
			InputStreamReader inr = new InputStreamReader(ins, charset);
			BufferedReader bfr = new BufferedReader(inr);

			String line = "";

			do {
				res.append(line);
				line = bfr.readLine();
				// System.out.println(line);
			} while (line != null);

			System.out.println("Value>>" + res);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}
		return res.toString();
	}
	
	
	public static String post(String url, String contents){
		try{   
            System.out.println("post>>>"+url);  
               
            URL serverUrl = new URL(url);  
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();   
            conn.setRequestMethod("POST");//"POST" ,"GET"   
             
            conn.addRequestProperty("Referer", refer);  
            conn.addRequestProperty("Cookie", cookie);  
            conn.addRequestProperty("Host", "d.web2.qq.com;");//GB2312,  
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");  
            conn.setDoOutput(true);   
            conn.connect();  
            System.out.println("contents:"+contents);
            conn.getOutputStream().write(contents.getBytes());  
            
//            if(conn.getHeaderFields().get("Set-Cookie") != null){  
//                for(String s:conn.getHeaderFields().get("Set-Cookie")){  
//                    cookie += s;  
//                }  
//            }  
              
            InputStream ins =  conn.getInputStream();  
              
            String charset = "UTF-8";   
            InputStreamReader inr = new InputStreamReader(ins, charset);  
            BufferedReader bfr = new BufferedReader(inr);  
             
            String line = "";  
            StringBuffer res = new StringBuffer();   
            do{  
                res.append(line);  
                line = bfr.readLine();  
               //System.out.println(line);  
            }while(line != null);  
            
            System.out.println(">>>==="+res);  
              
            return res.toString();  
        }catch(Exception e){  
            e.printStackTrace();  
            return null;  
        }  
	}
	
	public static String post1(String url, String contents){
		try{   
            System.out.println("post>>>"+url);  
               
            URL serverUrl = new URL(url);  
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();   
            conn.setRequestMethod("POST");//"POST" ,"GET"   
             
            System.out.println("-----Cookie--------");
            System.out.println(cookie);
            conn.addRequestProperty("Cookie", cookie);  
            conn.addRequestProperty("Host", "d.web2.qq.com");//GB2312,  
            conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; GTB6.4; EmbeddedWB 14.52 from: http://www.bsalsa.com/ EmbeddedWB 14.52; CIBA; .NET CLR 2.0.50727)");
            conn.addRequestProperty("Referer", "http://d.web2.qq.com/proxy.html?v=20110331002&callback=2");
            conn.setDoOutput(true);   
            conn.connect();  
            System.out.println("contents:"+contents);
            conn.getOutputStream().write(contents.getBytes());  
            
//            if(conn.getHeaderFields().get("Set-Cookie") != null){  
//                for(String s:conn.getHeaderFields().get("Set-Cookie")){  
//                    cookie += s;  
//                }  
//            }  
              
            InputStream ins =  conn.getInputStream();  
              
            String charset = "UTF-8";   
            InputStreamReader inr = new InputStreamReader(ins, charset);  
            BufferedReader bfr = new BufferedReader(inr);  
             
            String line = "";  
            StringBuffer res = new StringBuffer();   
            do{  
                res.append(line);  
                line = bfr.readLine();  
               //System.out.println(line);  
            }while(line != null);  
            
            System.out.println(">>>==="+res);  
              
            return res.toString();  
        }catch(Exception e){  
            e.printStackTrace();  
            return null;  
        }  
	}
	//���Cookie������õ�����ֵ
	public static String getValue(String key){
		String value = "" ;
		String str = cookie.substring(cookie.indexOf(key));
		value = str.substring(str.indexOf("=")+1, str.indexOf(";"));
		
		return value ;
	}
}
