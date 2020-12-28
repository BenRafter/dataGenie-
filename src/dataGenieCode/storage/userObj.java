package dataGenieCode.storage;

import dataGenieCode.helper.assistantFunctionsInterface;

public class userObj implements userInterface{
	private String _userName; 
	private String _password; 
	private boolean _isAdmin; 
	private assistantFunctionsInterface assistor = new assistantFunctions();
	
	/**
	 * Initializes the user object. No nulls are allowed.
	 * @param username - The username for this user. No spaces are allowed, spaces around the username will be
	 * trimmed. 
	 * @param password - The password for this user. No spaces are allowed, must be at least 8 characters long, 
	 * have at least 1 number, and at least 1 special character (!@#$%^&*) 
	 * @param adminStatus - True or False if the user is an admin.
	 * @throws IllegalArgumentException if password parameters are invalidated. 
	 */
	public userObj(String username, String password, boolean adminStatus) {
		if(username == null) {
			throw new IllegalArgumentException("Username is null, not allowed");
		}
		if(assistor.hasSpaces(username) == true) {
			throw new IllegalArgumentException("Username has spaces, not allowed");
		}
		_userName = username.trim();//The above block checks if the username is not null and has no spaces. 
		////////////////////////////
		if(assistor.passwordChecker(password) == false) {
			throw new IllegalArgumentException("Password breaks the rules, make a new one");
		}
		_password = password.trim();//The above block checks to see if the password follows the rules. 
		///////////////////////////
		_isAdmin = adminStatus;
	}
	
	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String username) {
		// TODO Auto-generated method stub
		if(username.equals(null)) {
			throw new IllegalArgumentException("username is null, not allowed");
		}
		
		if(assistor.hasSpaces(username)==false) {
			_userName = username;
		}else {
			throw new IllegalArgumentException("Username has spaces, not allowed");
		}
	}

	@Override
	public String getPassword() {
		return _password;
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		if(assistor.passwordChecker(password) == true) {
			_password = password;
		}else {
			throw new IllegalArgumentException("Password does not follow the rules");
		}
	}

	@Override
	public boolean isAdmin() {
		return _isAdmin;
	}

	@Override
	public void setAdminStatus(boolean isAdmin) {
		_isAdmin = isAdmin;
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Username = " + this._userName + ", Passowrd = " + this._password +
				", Admin Status = " + this._isAdmin);
		return buffer.toString();
	}
	
	public int hashcode() {
		int result = 17; 
		result = 37 * result + _userName.hashCode(); 
		result = 37 * result + _password.hashCode();
		if(_isAdmin == true) {
			result = 37 * result + 1;
		}else {
			result = 37 * result + 2;
		}
		return result;
	}
	
	public boolean equals(Object otherUser) {
		if(otherUser == this) {
			return true;
		}
		if(!(otherUser instanceof userObj)) {
			return false;
		}
		userObj uo = (userObj)otherUser;
		return uo._userName == this._userName && uo._password == this._password && uo._isAdmin == this._isAdmin;
	}
}
