package src.main.java;

public class User {
	private ATMaccount account = new ATMaccount(this);
	private String name;
	public User(String name) {
		this.name = name;
	}
	public ATMaccount getAccount() {
		return account;
	}
	
	public String getName() {
		return name;
	}
}
