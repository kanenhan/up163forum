package com.hanmanyi.qq.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class MyListRenderer extends JLabel implements MouseListener,
		ListCellRenderer {

	private JList list = null;
	private Border selectedBorder = BorderFactory.createLineBorder(Color.BLUE,2);
	private Border emptyBorder = BorderFactory.createEmptyBorder(1,1,1,1);

	public MyListRenderer(JList list) {

		this.list = list;
		this.addMouseListener(this);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		MyListItem item = (MyListItem)value;
		
		this.setText(item.getItemText());
		this.setIcon(item.getIconIterm());
		 if(isSelected) {
			 setBorder(selectedBorder);
			 this.setOpaque(true);
			 this.setBackground(Color.LIGHT_GRAY);
		 }
         else{ 
        	 setBorder(emptyBorder);
        	 this.setOpaque(true);
        	 this.setBackground(Color.WHITE);
         }

		return this;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int index = list.locationToIndex(e.getPoint());
		MyListItem item = (MyListItem) list.getModel().getElementAt(index);
		System.out.println("clicked");
	    if (((SelectEnable) item).getSelectEnable()) {
	    	System.out.println(item.getItemText());
	    }
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Enter");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Exit");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("pressed");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Released");
	}

}
