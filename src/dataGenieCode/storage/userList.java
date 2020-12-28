package dataGenieCode.storage;

import java.util.ArrayList;

public class userList implements dataBaseInterface{
	private userObj _currentUser;
	private ArrayList<userObj> _data;
	
	public void userListSet(){
		_data = new ArrayList<userObj>();
	}

	@Override
	public Boolean setCurrentUser(String username, String password) {
		if(checkIfUserExists(username, password) == false) {
			throw new IllegalArgumentException("User does not exist");
		}
		_currentUser = getSpecificUser(username, password);
		return true;
	}

	@Override
	public userObj getCurrentUser() {
		return _currentUser;
	}

	@Override
	public userObj getSpecificUser(String username, String password) {
		userObj result = null;
		if(checkIfUserExists(username, password) == false) {
			return null;
		}
		for(int i = 0; i < _data.size(); i++) {
			userObj userTemp = _data.get(i);
			if(userTemp.getUserName().equals(username)) {
				result = userTemp;
			}
		}
		return result;
	}

	@Override
	public boolean checkIfUserExists(String username, String password) {
		for(int i = 0; i < _data.size(); i++) {
			userObj userTemp = _data.get(i);
			if(userTemp.getUserName().equals(username) && userTemp.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void addToUserList(userObj userToAdd) {
		String usernameTemp = userToAdd.getUserName();
		String userpassTemp = userToAdd.getPassword();
		if(checkIfUserExists(usernameTemp, userpassTemp) == true) {
			throw new IllegalArgumentException("No user duplicates allowed");
		}
		_data.add(userToAdd);
	}

	@Override
	public void clearDB() {
		_data.clear();
	}

	@Override
	public int size() {
		return _data.size();
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Database:\n");
		for(int i = 0; i < _data.size(); i++) {
			userObj userTemp = _data.get(i);
			buffer.append(" ");
			buffer.append(userTemp.toString());
			buffer.append("\n");
		}
		return buffer.toString();
	}

}
