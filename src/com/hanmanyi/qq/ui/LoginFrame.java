package com.hanmanyi.qq.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JPanel implements ActionListener{
	
	private static String vcFilePath = "res/vc.jpeg";
	private static JLabel numLabel = new JLabel("用户名");
	private static JTextField numField = new JTextField();
	private static JLabel passwordLabel = new JLabel("密码");
	private static JPasswordField passwordField = new JPasswordField();
	private static JLabel vcLabel = new JLabel("验证码");
	private static JTextField vcField = new JTextField();
	private static JLabel vcShow = new JLabel(new ImageIcon(vcFilePath));
	private static JButton ok = new JButton("OK");
	private static JButton cancel = new JButton("Cancel");
	
	protected void addButton(JComponent component, GridBagLayout gridbag, GridBagConstraints c) {
		gridbag.setConstraints(component, c);
		add(component);
	}

	public LoginFrame(){
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		this.setLayout(gridbag);
		
		c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        addButton(numLabel, gridbag, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        addButton(numField, gridbag, c);
		
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        addButton(passwordLabel, gridbag, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        addButton(passwordField, gridbag, c);

        c.gridwidth = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.gridwidth = 3;
        addButton(vcLabel, gridbag, c);
        addButton(vcField, gridbag, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        addButton(vcShow, gridbag, c);
		
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.weightx = 1.0;
        addButton(ok, gridbag, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        addButton(cancel, gridbag, c);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		JFrame f= new JFrame("QQ");
		f.add(new LoginFrame());
		f.setVisible(true);
		f.setSize(300, 150);
	}
	
}
