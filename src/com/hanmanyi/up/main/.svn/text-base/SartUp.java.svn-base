package com.hanmanyi.up.main;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

public class SartUp extends Thread{

	/**
	 * 格式：帖子地址_楼层ID
	 */
	private  String url;
	/**
	 * 格式：帖子地址
	 */
	private  String refer;
	/**
	 * 格式：顶次数
	 */
	private  Integer num;
	
	/**
	 *  已执行次数
	 */
	private Integer excuted_num = 0;
	
	SartUp(String url, String refer, Integer num){
		this.url = url;
		this.refer = refer;
		this.num = num;
	}
	
	@Override
	public void run() {
		super.run();
		doUp();
	}
	
	private void doUp(){
		System.out.println("开始点顶...["+url+"]");
//		if(num<10){
				UpExcute ue = new UpExcute(url,refer,num);
				ue.start();
//		}else{
//			int numInOneThread = num/10+1;
//			
//			for (int i = 0; i < 10; i++) {
//				UpExcute ue = new UpExcute(url,refer,numInOneThread);
//				ue.start();
//			}
//		}
	}
	public static class UTF8PostMethod extends PostMethod{   
		public UTF8PostMethod(String url){   
		super(url);   
		}   
		@Override   
		public String getRequestCharSet() {   
			return "UTF-8";   
		}
	}
	
	public static class UpExcute extends Thread{   
		/**
		 * 格式：帖子地址_楼层ID
		 */
		private  String url;
		/**
		 * 格式：帖子地址
		 */
		private  String refer;
		/**
		 * 格式：顶次数
		 */
		private  Integer num;
		UpExcute(String url,String refer,Integer num){
			this.url = url;
			this.refer = refer;
			this.num = num;
		}
		@Override
		public void run() {
			super.run();
			//定义httpClient的实例
			HttpClient httpclient = new HttpClient();
			//创建post方法实例 http://comment.news.163.com/reply/upvote/news3_bbs/9PJM4U7N00014AED_9PJU5MMC
			PostMethod postMethod = new UTF8PostMethod(url);
			try{
				
				postMethod.setRequestHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
				postMethod.setRequestHeader("Accept-Encoding", "gzip,deflate");
				postMethod.setRequestHeader("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
				postMethod.setRequestHeader("Cache-Control", "no-cache");
				postMethod.setRequestHeader("Connection", "keep-alive");
				postMethod.setRequestHeader("Content-Length", "0");
				postMethod.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				postMethod.setRequestHeader("Cookie", 
								"posttime=9PKSSVR9_{};" +
								" locOfHebeiSite=others; nteslogger_exit_time=1398150927350");
				postMethod.setRequestHeader("Host", "comment.news.163.com");
				postMethod.setRequestHeader("Pragma", "no-cache");
				postMethod.setRequestHeader("Referer", refer);
				postMethod.setRequestHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:28.0) Gecko/20100101 Firefox/28.0");
				postMethod.setRequestHeader("X-Requested-With", "XMLHttpRequest");
			
			
				for (int i = 0; i < num; i++) {
					//执行post方法
					int statusCode = httpclient.executeMethod(postMethod);
					Thread.sleep(1*1000);
					System.out.println(new Date().toLocaleString()+":已顶"+(i+1)+"次，共"+num+"次["+url.substring(url.lastIndexOf("/"))+"]");
				}
			}catch (HttpException e1) {
				try {
					Thread.sleep(1*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println("Don`t worry, connections are too much,have a rest,then go on.");
//				e1.printStackTrace();
			} catch (IOException e1) {
//				e1.printStackTrace();
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}finally{
				postMethod.releaseConnection();
			}
		}
	}
}
