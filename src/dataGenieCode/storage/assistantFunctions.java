package dataGenieCode.storage;

import dataGenieCode.helper.assistantFunctionsInterface;

final class assistantFunctions implements assistantFunctionsInterface{

	@Override
	public boolean hasSpaces(String x) {
		// TODO Auto-generated method stub
		for(char c : x.toCharArray()) {
			if(Character.isWhitespace(c)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean passwordChecker(String x) {
		// TODO Auto-generated method stub
		boolean hasSpecial = false;
		boolean hasNumber = false;
		
		if(hasSpaces(x) == true) {
			return false;
		}//If x has spaces, it doesn't follow the rules 
		
		if(x.length() < 8) {
			return false;
		}//If x is less than 8 characters long, it doesn't follow the rules 
		
		if(x.contains("!")||
		   x.contains("@")||
		   x.contains("#")||
		   x.contains("$")||
		   x.contains("%")||
		   x.contains("^")||
		   x.contains("&")||
		   x.contains("*")) {
			hasSpecial = true;
		}//This block checks if  the password contains one of the special characters
		
		for(char c : x.toCharArray()) {
			if(Character.isDigit(c)) {
				hasNumber = true;
			}
		}//This block checks if there is at least 1 number in x 
		
		if(hasSpecial == true && hasNumber == true) {
			return true;
		}//If the code has reached  this point and hasSpecial is true and hasNumber is true then x follows the rules
		
		return false;
	}

}
