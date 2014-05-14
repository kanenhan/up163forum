package com.hanmanyi.qq.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.io.File;

/*
 * QQMd5ͨ���������֤��õ���½ʹ�õ�����
 * 
 */
public class QQMd5 {

	public static String mdP(String p, String code){  
		Object t = null ;
        try {  
            ScriptEngineManager m = new ScriptEngineManager();  
            ScriptEngine se = m.getEngineByName("javascript");  
            se.eval(new FileReader(new File("comm.js")));  
            t = se.eval("md5(md5_3(\""+p+"\")+\""+code.toUpperCase()+"\");");  
            return t.toString();  
        }catch (Exception e) {  
            e.printStackTrace();  
        }   
        return t.toString();  
    }  
	
	public static void main(String[] args){
		System.out.println(mdP("yww123321","!GMI"));
	}

}
