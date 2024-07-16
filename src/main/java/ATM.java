package src.main.java;

import java.util.HashMap;
import java.util.Map;

public class ATM {
	Map<String,ATMaccount> accounts = new HashMap<>();
	private Application app;
	public ATM(Application app) {
		this.app = app;
	}
	public ATMaccount getAccountUser(String name) {
		if(!accounts.containsKey(name)) {
			var account = app.makeAccount(name,this);
			return account;
		}
		accounts.get(name).open();
		return accounts.get(name);
	}
	
	public void addAccount(ATMaccount account, String name) {
		accounts.put(name, account);
	}

}
