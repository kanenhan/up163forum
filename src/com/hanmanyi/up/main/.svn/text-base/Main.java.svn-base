package com.hanmanyi.up.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.hanmanyi.up.beans.GlobalSettings;
import com.ztools.xml.XMLReader;

/**
 * 163 跟帖顶
 * 
 * */
public class Main {

	/**
	 * 配置文件地址
	 */
	public static final String GLOBAL_SETTINGS = "conf/";
	
	private static void init(){
		System.out.println("开始读取配置信息...");
		File f = new File(System.getProperty("user.dir")+"/"+GLOBAL_SETTINGS);
		if(f == null || !f.isDirectory()){
			System.out.println(System.getProperty("user.dir")+"/"+GLOBAL_SETTINGS + "没有该目录");
			return ;
		}
		File[] fs = f.listFiles();
		for (int i = 0; i < fs.length; i++) {
			InputStream in;
			try {
				in = new FileInputStream(fs[i]);
				Object obj = XMLReader.xmlStreamToObject(in,null);
				
				if(obj != null && obj instanceof List){
					@SuppressWarnings("unchecked")
					List<GlobalSettings> list = (List<GlobalSettings>)obj;
					for (int j = 0; j < list.size(); j++) {
						String url = null;
						String refer = null;
						Integer num = null;
						url = ((GlobalSettings)list.get(j)).getUrl();
						refer = ((GlobalSettings)list.get(j)).getRefer();
						num = ((GlobalSettings)list.get(j)).getNum();
						
						System.out.println("目标地址（跟帖地址）:"+url);
						System.out.println("帖子地址:"+refer);
						System.out.println("要顶的次数:"+num);
						
						SartUp su = new SartUp(url,refer,num);
						su.start();
					}
					
				}
				
				if(obj != null && obj instanceof GlobalSettings){
					String url = null;
					String refer = null;
					Integer num = null;
					
					url = ((GlobalSettings)obj).getUrl();
					refer = ((GlobalSettings)obj).getRefer();
					num = ((GlobalSettings)obj).getNum();
					
					System.out.println("目标地址（跟帖地址）:"+url);
					System.out.println("帖子地址:"+refer);
					System.out.println("要顶的次数:"+num);
					
					SartUp su = new SartUp(url,refer,num);
					su.start();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		init();// 配置
	}
}
