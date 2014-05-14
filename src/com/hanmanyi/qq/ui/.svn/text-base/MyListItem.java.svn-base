package com.hanmanyi.qq.ui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;

public class MyListItem  implements IconItem, SelectEnable, ItemText{

	private String text ;
	private boolean selected ;
	private Icon icon ;
	private static Icon  defaultIcon = null;

	static{
		defaultIcon = new ImageIcon("res/2.JPG");
	}
	
	public MyListItem(String text){
		this(text, true, defaultIcon);
	}
	
	public MyListItem(String text, boolean selected){
		this(text,selected,defaultIcon);
	}
	public MyListItem(String text, boolean selected, Icon icon){
		this.text = text ;
		this.selected = selected ;
		this.icon = icon;
	}
	@Override
	public void setSelectEnable(boolean selected) {
		// TODO Auto-generated method stub
		this.selected = selected;
	}

	@Override
	public boolean getSelectEnable() {
		// TODO Auto-generated method stub
		return selected;
	}

	@Override
	public void setIconIterm(Icon icon) {
		// TODO Auto-generated method stub
		this.icon = icon;
	}

	@Override
	public Icon getIconIterm() {
		// TODO Auto-generated method stub
		return icon;
	}
	@Override
	public void setItemText(String text) {
		// TODO Auto-generated method stub
		this.text = text;
	}
	@Override
	public String getItemText() {
		// TODO Auto-generated method stub
		return text;
	}
	
}
