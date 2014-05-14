package com.hanmanyi.up.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ztools.xml.XMLWriter;

/**
 * 全局设置
 * @author hanmanyi
 *
 */
public class GlobalSettings {
	/**
	 * 格式：帖子地址_楼层ID
	 */
	private String url;
	/**
	 * 格式：帖子地址
	 */
	private String refer;
	/**
	 * 格式：顶次数
	 */
	private Integer num;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the refer
	 */
	public String getRefer() {
		return refer;
	}

	/**
	 * @param refer
	 *            the refer to set
	 */
	public void setRefer(String refer) {
		this.refer = refer;
	}

	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @param num
	 *            the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public static final String GLOBAL_SETTINGS = "conf/";
	public static void main(String[] args) {
		List<GlobalSettings> list = new ArrayList<GlobalSettings>(); 
		for (int i = 0; i < 5; i++) {
			GlobalSettings gs = new GlobalSettings();
			
			gs.setUrl("http://comment.news.163.com/reply/upvote/news3_bbs/9PJM4U7N00014AED_9PJRMSDQ");
			gs.setRefer("http://comment.news.163.com/news3_bbs/9PJM4U7N00014AED.html");
			gs.setNum(1000);
			list.add(gs);
		}
		try {
			XMLWriter.writeObjectToXmlFile(list,GLOBAL_SETTINGS+"globalsettings.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
