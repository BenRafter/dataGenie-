package dataGenieCode.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import dataGenieCode.storage.userList;

public class adminPage {
	userList data; 
	addUserPage addPage;
	
	public adminPage(userList list) {
		this.data = list;
		this.addPage = new addUserPage(list);
	}
	
	public void startAdminPage() {
		JFrame f = new JFrame("Admin Page"); 
		
		JButton displayUsers = new JButton("Display current users");
		displayUsers.setBounds(150, 200, 100, 40);
		displayUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, data.toString());
			}
		});
		f.add(displayUsers);
		
		JButton addUser = new JButton("Add new user");
		addUser.setBounds(150, 300, 100, 40);
		addUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPage.startAdduserPage();
			}
		});
		f.add(addUser);
		
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
