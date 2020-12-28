package dataGenieCode.ui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import dataGenieCode.storage.userList;

public class addUserPage {
	userList data; 
	
	public addUserPage(userList list) {
		this.data = list;
	}
	
	public void startAdduserPage() {
		JFrame f = new JFrame("Add Users");
		
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
	}
	
	
}
