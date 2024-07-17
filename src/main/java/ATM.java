package src.main.java;

import java.util.HashMap;
import java.util.Map;

public class ATM {
	Map<String,ATMaccount> accounts = new HashMap<>();
	public ATM() {
	}
	
	public boolean hasAccount(String name) {
		return accounts.containsKey(name);
	}
	
	/**
	 * @precondition | accounts.containsKey(name)
	 */
	public ATMaccount getAccountUser(String name) {
		return accounts.get(name);
	}
	
	public void addAccount(ATMaccount account, String name) {
		accounts.put(name, account);
	}
	
	
	public ATMaccount makeAccount(String name) {
		var user = new User(name);
		addAccount(user.getAccount(), name);
		return getAccountUser(name);
	}

}
