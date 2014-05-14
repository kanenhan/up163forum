package com.hanmanyi.qq.util;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VerifyCode {

	private static String savePath = "res/verifyUID.jpeg";
	private static JFrame frame = new JFrame("��������֤��");
	private static JLabel vcLabel;
	private static JTextField vcField = new JTextField();
	private static JButton okBtn = new JButton("ȷ��");
	private static String verifyCode = "";
	private static String defaultURL;

	public static void getVCImg(String sourceURL) {
		URL getVerifyURL;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		URLConnection con = null;

		try {
			getVerifyURL = new URL(sourceURL);
			con = getVerifyURL.openConnection();
			// ��ʵû�б�Ҫ�ж�
			Object o = getVerifyURL.getContent();
			if (o instanceof ImageProducer) {
				System.out.println("image");
				bis = new BufferedInputStream(con.getInputStream());
				fos = new FileOutputStream(savePath);
				byte[] bs = new byte[1024];
				int len;
				while ((len = bis.read(bs)) != -1) {
					fos.write(bs, 0, len);
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		} finally {
			try {
				bis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public static void getVC(String sourceURL) {

		getVCImg(sourceURL);
			vcLabel = new JLabel(new ImageIcon("res/verifyUID.jpeg"));
			frame.setLayout(new GridLayout(3, 1));
			frame.add(vcLabel);
			frame.add(vcField);
			frame.add(okBtn);

			vcField.setSize(frame.getWidth(), 30);
			okBtn.setSize(frame.getWidth(), 30);
			okBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (!vcField.getText().equals("")) {
						verifyCode = new String(vcField.getText());
						System.out.println(verifyCode);
						frame.dispose();
					}
				}
			});
			frame.setSize(100, 150);
			frame.setVisible(true);
	}

	public static String getVerifyCode(String qq){
		defaultURL = "http://captcha.qq.com/getimage?aid=1003903&r=0.6869804609544552&uin="+qq+"&vc_type=8A6143167C8CA486696CF01C3EA088D658B913D64B11289B";
		return getVerifyCode(qq, defaultURL);
	}
	
	public static String getVerifyCode(String qq, String source){
		getVC(source);
		do{
		} while(verifyCode.equals(""));
		return verifyCode;
	}
	
	public static void main(String[] args) {
		String sourceURL = "http://captcha.qq.com/getimage?aid=1003901&0.7919972321179474";
		System.out.println("f��" + getVerifyCode("47120640"));
	}
}
