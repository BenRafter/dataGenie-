import dataGenieCode.storage.userList;
import dataGenieCode.storage.userObj;
import dataGenieCode.ui.loginPage;

public class startUp {
	public static void main(String[] args) {
		userObj user1 = new userObj("username1", "password1!", true);
		userObj user2 = new userObj("username2", "password2!", false);
		userList test = new userList(); 
		test.userListSet(); 
		test.addToUserList(user1);
		test.addToUserList(user2);
		loginPage lp = new loginPage(test); 
		lp.startLogin();
	}
}
