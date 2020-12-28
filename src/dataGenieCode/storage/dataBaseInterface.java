package dataGenieCode.storage;

public interface dataBaseInterface {
	
	/**
	 * Adds userToAdd to the user list
	 * @param userToAdd The user to be added to the user list
	 */
	public void addToUserList(userObj userToAdd);
	
	/**
	 * Using the provided userame and password, the user list is searched 
	 * to see if this user exists and then sets the current user as the 
	 * desired user. 
	 * @param username The username of the desired user
	 * @param password The password of the desired user 
	 * @return 
	 * @throws An illegalArgumentException if there is a duplicate when tring to
	 * add a new user
	 */
	public Boolean setCurrentUser(String username, String password);
	
	/**
	 * 
	 * @return The userObj of the current user 
	 */
	public userObj getCurrentUser();
	
	/**
	 * Searches through the user list and returns the userObj of username if
	 * one exists. 
	 * @param username The username of the user you want returned 
	 * @return The userObj linked to username
	 */
	public userObj getSpecificUser(String username, String password);
	
	/**
	 * Checks the user list to see if a user with the username string exists.
	 * @param username The username of the user you want to check exists
	 * @return True if the user does exists, false if the user doesn't exist
	 */
	public boolean checkIfUserExists(String username, String password);
	
	/**
	 * @return Returns the user list as a string 
	 */
	public String toString();
	
	/**
	 * Clears the user list
	 */
	public void clearDB();
	
	/**
	 * @return The size of the user list
	 */
	public int size();
}
