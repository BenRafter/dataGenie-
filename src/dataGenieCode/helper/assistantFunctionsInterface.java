package dataGenieCode.helper;

public interface assistantFunctionsInterface {
	
	/**
	 * This functions checks if the string x has spaces in it or not. 
	 * @param x The string to be checked 
	 * @return True if there is spaces in x, false if there are no spaces in x
	 */
	public boolean hasSpaces(String x);
	
	/**
	 * This functions checks to see if the string x follows the rules for password, which are:
	 * At least 8 characters long, has at least 1 number, no spaces, and has at least 1 special character (!@#$%^&*)
	 * @param x The string to be checked 
	 * @return True if x follows the rules for passwords, false if x does not follow the rules for 
	 * passwords
	 */
	public boolean passwordChecker(String x);
}
