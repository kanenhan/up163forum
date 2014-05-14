package com.hanmanyi.qq.main;
/*
 * GetUIDFromQQ根据给定的QQ号码得到UID
 * 过程中需要手动输入验证码
 * 
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.hanmanyi.qq.util.VerifyCode;

public class GetUIDFromQQ {

	private static String verifyURL = "http://captcha.qq.com/getimage?aid=1003901&0.7919972321179474";
	private static String url = "http://s.web2.qq.com/api/get_single_info2?";
	//tuin=347073999&verifysession=h008a68d5b4326b24ac83f93380c2d4d420b07a63fe965e67c6dc305b10cf3bba76caf02dff8b503298&code=bwmq&vfwebqq=4058ec0d308ee108e90228af177e6deb44ed14a2a09a1ea23e01b8b54873cfe0cfaf62a5b060da7d&t=1305877483156";
	
	private static String getVC(JTextField field){
		return field.getText();
	}

	
	public static void main(String[] args){
	}
}
