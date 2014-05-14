package com.hanmanyi.qq.main;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;


public class QQClient {

	private int qq = -1;
	private String pwd = null;
	
	private int clientid = 66933334;//这个可以随便写
	private String psessionid = "";
	
	private String ptwebqq;
	private String vfwebqq;
	
	private String skey;
	
	private String refer = "http://web2-b.qq.com/proxy.html";
	
	private String cookie = "";
	//读取消息线程
	private boolean isrun = false;
	private Thread poolThread =new PollThread();
	public Thread getPoolThread() {
		return poolThread;
	}
	/**
	 * 记录日志
	 */
	private void log(String msg){
		System.out.println(new Date().toLocaleString()+":"+msg);
	}
	
	
	public QQClient(int qq, String pwd) { 
		this.qq = qq;
		this.pwd = pwd;
		try {
			boolean rs = checkAndLogin();
			if(rs){ 
				isrun = true;
				poolThread.start();//开始循环接收
				log("启动成功");
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	/*****************华丽的分界线*****************/
	//测试
	public static void main(String[] args) throws Exception{
		QQClient q = new QQClient(1506214893, "yww123321"); 
		q.getPoolThread().join();
	}
	
	/*****************华丽的分界线*****************/
	/**
	 * 给toQQ发送一个msg消息，前提是toQQ是你的好友，要不然他收不到
	 */
	public boolean sendMsg(int toQQ, String message){
		try {
			JSONObject json = new JSONObject();
			json.put("to", toQQ);//要发送的人
			json.put("face", 0);
			
			JSONArray msg = new JSONArray();
			msg.add(message);
			JSONArray font = new JSONArray();
			font.add("font");
			
			JSONObject font1 = new JSONObject().put("name", "宋体").put("size", "10");
			
			JSONArray style = new JSONArray();
			style.add(0);
			style.add(0);
			style.add(0);		
			font1.put("style", style);
			font1.put("color", "000000");
			
			font.add(font1);	 
			msg.add(font);
			
			json.put("content", msg.toString());
			json.put("msg_id", new Random().nextInt(10000000));
			json.put("clientid", clientid);
			json.put("psessionid", psessionid);//需要这个才能发送
			String sendMsgUrl = "http://web2-b.qq.com/channel/send_msg";
			String content = json.toString();
			 
			content = URLEncoder.encode(content);//他要需要编码
			content ="r="+content;
			//发送
			String res = postUrl(sendMsgUrl, content);
			//不出意外，这是返回结果：{"retcode":0,"result":"ok"}
			JSONObject rh = new JSONObject(res);
			if("ok".equals(rh.getString("result"))){
				return true;
			} 
		} catch (JSONException e) { 
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 检查并且登陆
	 */
	private boolean checkAndLogin() throws Exception{
		if(qq == -1 || pwd == null)
			throw new IllegalArgumentException("qq和密码不能为空");
		String checkIdUrl = "http://ptlogin2.qq.com/check?appid=1003903&uin="+qq;
		String res = getUrl(checkIdUrl);
		//ptui_checkVC('0','!ZLE');返回这个就不需要获取验证码了。验证码就是!ZLE 
		//ptui_checkVC('1','95ab7db15e5ab17f50f25d33598259e83ccc098c4af2f8a4');这个长字符串就需要使用了
		Pattern p = Pattern. compile("\\,\\'([!\\w]+)\\'");
		Matcher m = p. matcher(res);
		String checkType = "";
		if(m.find()){
			checkType = m.group(1); 
		}
		String check = ""; 
		if(!checkType.startsWith("!")){
			//需要输入验证码
			String getCheckImageUrl = "http://captcha.qq.com/getimage?aid=1003903&uin="+qq+"&vc_type="+checkType;
			String file = readCheckImage(getCheckImageUrl);
			log("请打开"+file+"，并且在这里输入其中的字符串，然后回车：");
			InputStreamReader ins = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(ins);
			check = br.readLine();	
		}else{
			//不需要输入验证码
			check = checkType;
		}
		
		//开始登陆
		String loginUrl = "http://ptlogin2.qq.com/login?u="+qq+"&" +
				"p=" +mdP(pwd, check)+
				"&verifycode="+check+"&remember_uin=1&aid=1003903" +
				"&u1=http%3A%2F%2Fweb2.qq.com%2Floginproxy.html%3Fstrong%3Dtrue" +
				"&h=1&ptredirect=0&ptlang=2052&from_ui=1&pttype=1&dumy=&fp=loginerroralert";
		res = getUrl(loginUrl);
//		ptuiCB('0','0','http://web2.qq.com/loginproxy.html?strong=true','0','登录成功！');
//		ptuiCB('4','0','','0','您输入的验证码有误，请重试。');
	 
		p = Pattern.compile("登录成功！");//提取最后一个字符串，看看是不是 登录成功！
		m = p. matcher(res);
		if(m.find()){
			log("登陆成功"); 
		}else{
			//登陆失败
			log(checkType);
			return false;
		}
		//从cookie中提取ptwebqq,skey
		p = Pattern.compile("ptwebqq=(\\w+);");
		m = p.matcher(cookie);
		if(m.find()){
			ptwebqq = m.group(1);
		}
		p = Pattern.compile("skey=(@\\w+);");
		m = p.matcher(cookie);
		if(m.find()){
			skey = m.group(1);
		}
		log("ptwebqq="+ptwebqq+",skey="+skey);
		
		//再次登陆，只有这次登陆，才算真正登陆qq，这个时候，如果你qq已经登陆，会把你的qq踢下线，而且此次登陆才算上线。
		String channelLoginUrl = "http://web2-b.qq.com/channel/login";
		String content = "{\"status\":\"\",\"ptwebqq\":\""+ptwebqq+"\",\"passwd_sig\":\"\",\"clientid\":\""+clientid+"\"}";
		content = URLEncoder.encode(content);//urlencode 
		content = "r="+content;//post的数据
		res = postUrl(channelLoginUrl, content);//post
		//这次登陆基本上不会发生什么问题
		//下面提取很重要的2个数据psessionid ,vwebqq，通用采用正则表达式,虽然结果是个json
		p = Pattern.compile("\"vfwebqq\":\"(\\w+)\"");
		m = p.matcher(res);
		if(m.find()){
			vfwebqq = m.group(1);
		}
		p = Pattern.compile("\"psessionid\":\"(\\w+)\"");
		m = p.matcher(res);
		if(m.find()){
			psessionid = m.group(1);
		}
		log("vwebqq="+vfwebqq+","+"psessionid="+psessionid);
		//到此，登陆就算完成了，后面可以调用发送qq信息等接口了		
		 return true;
	}
	

	
	
	/**
	 * 调用tx的js来生成密钥
	 */
	public  String mdP(String p, String code){
		try {
			ScriptEngineManager m = new ScriptEngineManager();
			ScriptEngine se = m.getEngineByName("javascript");
			se.eval(new FileReader(new File("comm.js")));
			Object t = se.eval("md5(md5_3(\""+p+"\")+\""+code.toUpperCase()+"\");");
			return t.toString();
		}catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	/**
	 * POST一个url,contents是输入的内容
	 */
	private  String postUrl(String url, String contents){
		try{ 
			System.out.println("post>>>"+url);
			 
			URL serverUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection(); 
	        conn.setRequestMethod("POST");//"POST" ,"GET" 
	       
	        if(refer != null){
	        	conn.addRequestProperty("Referer", refer);
	        }
	        conn.addRequestProperty("Cookie", cookie);
	        conn.addRequestProperty("Accept-Charset", "UTF-8;");//GB2312,
	        conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
	        conn.setDoOutput(true); 
	        conn.connect();
	        
	        conn.getOutputStream().write(contents.getBytes());
	        
	        if(conn.getHeaderFields().get("Set-Cookie") != null){
		        for(String s:conn.getHeaderFields().get("Set-Cookie")){
		        	cookie += s;
		        }
	        }
	        
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
	
	
	/**
	 * GET 一个url
	 */
	private  String getUrl(String url){
		try{ 
			System.out.println("get>>>"+url);
			 
			URL serverUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection(); 
	        conn.setRequestMethod("GET");//"POST" ,"GET"
	       // conn.setDoOutput(true); 
	        if(refer != null){
	        	conn.addRequestProperty("Referer", refer);
	        }
	        conn.addRequestProperty("Cookie", cookie);
	        conn.addRequestProperty("Accept-Charset", "UTF-8;");//GB2312,
	        conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
	        conn.connect();
	       
	        if(conn.getHeaderFields().get("Set-Cookie") != null){
		        for(String s:conn.getHeaderFields().get("Set-Cookie")){
		        	cookie += s;
		        }
	        }
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
	
	/**
	 * 读取验证码。返回验证码文件保存的路径
	 */
	private String readCheckImage(String url){
		try{ 
			System.out.println("get>>>"+url);
		 
			URL serverUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection(); 
	        conn.setRequestMethod("GET");//"POST" ,"GET" 
	        
	        conn.addRequestProperty("Accept-Charset", "UTF-8;");//GB2312,
	        conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
	        conn.connect();
	        //返回的cookie
	        if(conn.getHeaderFields().get("Set-Cookie") != null)
		        for(String s:conn.getHeaderFields().get("Set-Cookie")){
		        	cookie += s;
		        }
	        
	        InputStream ins =  conn.getInputStream();
	        
	        BufferedImage bi = ImageIO.read(ins);
	        File f =new File("qqimg.jpg");
	        ImageIO.write(bi, "jpg", f);
	        
	        return f.getAbsolutePath();
		}catch(Exception e){
			e.printStackTrace(); 
		} 
		return null;
	}
	
	/**
	 * 当有qq消息是回调此函数
	 */
	public void receiveMsg(String message, int fromQQ){
		log("qq:"+fromQQ+"说:"+message);
		//test
		sendMsg(fromQQ, "然后呢？");
	}
	
	/**
	 * 通过poll一直等待服务器回应。比如收到消息啊，好友上线啊，申请好友啊之类的各类消息都会通过此接口返回，在获得数据后，应该继续poll获取下个数据
	 * http://web2-b.qq.com/channel/poll
	 */
	class PollThread extends Thread{
		
		private String pollUrl = "http://web2-b.qq.com/channel/poll";
		@Override
		public void run() { 
			String url = pollUrl+ "?clientid="+clientid+"&psessionid="+psessionid; 
			
			try {
				while(isrun){
					//线程一直等待知道服务器有返回数据
					String res = getUrl(url);
					
					JSONObject retJ = new JSONObject(res);
					if(retJ.getInt("retcode") == 0){
						JSONArray result = retJ.getJSONArray("result");
						String poll_type = result.getJSONObject(0).getString("poll_type");
						if("message".equals(poll_type)){
							//说明有人发qq消息给我，							
							String raw_content = result.getJSONObject(0).getJSONObject("value").get("raw_content").toString(); 
							int from_uin = result.getJSONObject(0).getJSONObject("value").getInt("from_uin");
							log("收到来自："+from_uin+":"+raw_content);
							//通知客户端收到了
							receiveMsg(raw_content, from_uin);
						}
						//system_message 是系统消息
					}
				}
			} catch (JSONException e) { 
				e.printStackTrace();
			}
		}
		
	}

	
}