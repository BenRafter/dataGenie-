package dataGenieCode.storage;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class userObjTest extends TestCase{
	
	@Test
	public void testConstructor() {
		String user1 = "XX";
		String password1 = "XX1!XXXX";
		boolean admin1 = true;
		
		userObj u1 = new userObj(user1, password1, admin1);
		Assert.assertSame(user1, u1.getUserName());
		Assert.assertSame(password1, u1.getPassword());
		Assert.assertSame(admin1, u1.isAdmin());
		
		String user2 = "YY";
		String password2 = "GF!1GSDFG$4";
		boolean admin2 = false; 
		
		userObj u2 = new userObj(user2, password2, admin2);
		Assert.assertSame(user2, u2.getUserName());
		Assert.assertSame(password2, u2.getPassword());
		Assert.assertSame(admin2, u2.isAdmin());
	}
	
	@Test
	public void testExceptionUsername(){
		try {
			new userObj("C C", "A!1!AAAAAAA", true);
			fail();
		}catch(IllegalArgumentException e) {}
		try {
			new userObj("C C CC C ", "A!1!AAAAA", false);
			fail();
		}catch(IllegalArgumentException e) {}
		try {
			new userObj(" ", "AA!!1!AAAA", true);
			fail();
		}catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testPasswordException() {
		try {
			new userObj("CC", "CC", true);
			fail();
		}catch(IllegalArgumentException e) {}
		try {
			new userObj("CC", "C!1C", true);
			fail();
		}catch(IllegalArgumentException e) {}
		try {
			new userObj("CC", "C CC!1CCCCC", true);
			fail();
		}catch(IllegalArgumentException e) {}
		try {
			new userObj("CC", "CCCCCCCCC", true);
			fail();
		}catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testHashCode() {
		int firstHashCode = new userObj("AA", "AA!1AAAA", true).hashcode();
		Assert.assertEquals(firstHashCode, new userObj("AA", "AA!1AAAA", true).hashcode());
		
		int secondHashCode = new userObj("BB", "BB!1BBBB", false).hashcode();
		Assert.assertEquals(secondHashCode, new userObj("BB", "BB!1BBBB", false).hashcode());
		
		Assert.assertNotEquals(firstHashCode, secondHashCode);
	}
	
	@Test
	public void testEquals() {
		userObj testUser = new userObj("AA", "AA!1AAAA", true);
		userObj testUser2 = new userObj("AA", "AA!1AAAA", true);
		userObj testUser3 = new userObj ("BB", "BB!1BBBB", false); 
		
		Assert.assertTrue(testUser.equals(testUser2));
		Assert.assertTrue(testUser.equals(testUser));
		Assert.assertFalse(testUser.equals(testUser3));//Tests for testUser
		
		Assert.assertTrue(testUser2.equals(testUser));
		Assert.assertTrue(testUser2.equals(testUser2));
		Assert.assertFalse(testUser2.equals(testUser3));//Tests for testUser2
		
		Assert.assertFalse(testUser3.equals(testUser));
		Assert.assertFalse(testUser3.equals(testUser2));
		Assert.assertTrue(testUser3.equals(testUser3));//Tests for testUser3
	}

}
