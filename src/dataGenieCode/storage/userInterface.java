package dataGenieCode.storage;

public interface userInterface {
	/**
	 * @return The username for the user 
	 */
	public String getUserName();
	
	/**
	 * This function changes the username of the user object 
	 * @param username The username you want set as the user objects username 
	 */
	public void setUserName(String username);
	
	/**
	 * @return The password for the user 
	 */
	public String getPassword();
	
	/**
	 * This function changes the password of the user object. Will only accept the password if it 
	 * follows the rules: At least 8 characters long, no spcaes, has 1 number, and has at least 1 of the following
	 * special characters (!@#$%^&*) 
	 * @param password The password you want to set as the user objects password 
	 */
	public void setPassword(String password);
	
	/**
	 * @return True if the user is an admin, false if the user is not an admin
	 */
	public boolean isAdmin();
	
	/**
	 * Allows the user to be set as an admin. If isAdmin is true, the user will be an admin, 
	 * if isAdmin is false the user will not be an admin. 
	 * @param isAdmin True or false 
	 */
	public void setAdminStatus(boolean isAdmin);
	
	/**
	 * 
	 * @return The user as a string object 
	 */
	public String toString();
	
	/**
	 * 
	 * @return The hashcode for the user 
	 */
	public int hashCode();
	
	/**
	 * 
	 * @param otherUserObj - This is the other user object you want to see is equal 
	 * @return True if the two user objects are equal, false if they are not
	 */
	public boolean equals(Object otherUserObj);
}
