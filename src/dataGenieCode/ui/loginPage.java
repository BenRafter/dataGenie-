package dataGenieCode.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dataGenieCode.storage.userList;
import dataGenieCode.storage.userObj;

public class loginPage {
	userList data; 
	
	public loginPage(userList list) {
		this.data = list;
	}
	
	public void startLogin() {
		JFrame f = new JFrame("Login"); 
		
		JLabel userLabel, passLabel; 
		userLabel = new JLabel("Enter username: ");
		userLabel.setBounds(50,100,100,40);
		f.add(userLabel);
		
		passLabel = new JLabel("Enter password: ");
		passLabel.setBounds(50, 150, 100, 40);
		f.add(passLabel);
		
		JTextField userName, password;
		userName = new JTextField();
		userName.setBounds(150, 100, 150, 40);
		f.add(userName);
		
		password = new JTextField(); 
		password.setBounds(150, 150, 150, 40);
		f.add(password);
		
		JButton login = new JButton("Login"); 
		login.setBounds(150, 200, 100, 40);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Login button pressed");
				String user = userName.getText();
				String pass = password.getText(); 
				if(data.checkIfUserExists(user, pass) == true) {
					System.out.println("Exists");
					userObj temp = data.getSpecificUser(user, pass);
					if(temp.isAdmin()) {
						System.out.println("Opening admin page");
						adminPage newAP = new adminPage(data);
						newAP.startAdminPage();
						f.dispose();
					}else {
						System.out.println("Opening non admin page");
					}
				}else {
					System.out.println("Does not exists");
					JOptionPane.showMessageDialog(f, "Wrong user or password");
					
				}
			}
		});
		f.add(login);
		
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
