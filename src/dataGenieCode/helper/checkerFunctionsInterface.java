package dataGenieCode.helper;

public interface checkerFunctionsInterface {
	/**
	 * Goes into the user database and searched for the username and confirms if the password is correct.
	 * @param username The username of the user being checked.
	 * @param password The password of the user being checked. 
	 * @return True if the username and password exist in the database and match, false if not. 
	 */
	boolean checkUserExist(String username, String password);
}
