package com.hanmanyi.qq.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class FriendListPanel extends JLabel{

	private JList friendList = null;
	
	public FriendListPanel(){
		friendList = new JList();
		friendList.setCellRenderer(new MyListRenderer(friendList));

	}
	
	public static void main(String[] args){
		Icon icon = new ImageIcon("res/1.JPG");
		MyListItem[] items = { new MyListItem("Astart"),
		           new MyListItem("B-BIX", true, icon),
		           new MyListItem("郁闷", false), 
		           new MyListItem("abc", true),
		           new MyListItem("12867831", false, icon),
		};

		JList jList = new JList(items);
		jList.setCellRenderer(new MyListRenderer(jList));
		
		JFrame frame = new JFrame();
		frame.add(jList);
		frame.setSize(200, 200);
		frame.setVisible(true);
		
		

	}
}
