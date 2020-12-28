package dataGenieCode.storage;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class userListTest extends TestCase{
		userObj user1 = new userObj("SSSSSSS", "S!1SSSSSSSS", true);
		userObj user2 = new userObj("AA", "A2AA@@AAAA", false);
		userObj user3 = new userObj("BB", "B3$aFASdfdsS", true);
		userList ul = new userList();
	
		@Test
		public void testInitialization() {
			ul.userListSet();
			ul.clearDB();
			ul.addToUserList(user1);
			ul.addToUserList(user2);
			ul.addToUserList(user3);
			Assert.assertEquals(3, ul.size());
			System.out.println(ul.toString());
		}
		
		@Test
		public void dupTest() {
			ul.userListSet();
			ul.clearDB();
			ul.addToUserList(user1);
			try {
				ul.addToUserList(user1);
				Assert.fail();
			}catch(IllegalArgumentException e) {}
		}
		
		@Test
		public void testUserFind() {
			ul.userListSet();
			ul.clearDB();
			ul.addToUserList(user1);
			ul.addToUserList(user2);
			ul.addToUserList(user3);
			Assert.assertTrue(ul.checkIfUserExists(user1.getUserName(), user1.getPassword()));
			Assert.assertTrue(ul.checkIfUserExists(user2.getUserName(), user2.getPassword()));
			Assert.assertTrue(ul.checkIfUserExists(user3.getUserName(), user3.getPassword()));
		}
}
