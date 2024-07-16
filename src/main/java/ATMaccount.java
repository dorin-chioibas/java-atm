package src.main.java;

public class ATMaccount {
	private float balance;
	private User user;
	private boolean exit = false;
	
	public ATMaccount(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public float checkBalance() {
		return balance;
	}
	
	public void depositMoney(float money) {
		balance += money;
	}
	
	public void withdrawMoney(float amount) {
		if(amount > balance ) {
				ErrorHandling.insufficientFunds();
				return;
		}
		balance -= amount;
	}
	
	public void open() {
		this.exit = false;
	}
	
	public void close() {
		this.exit = true;
	}
	public boolean isClosed() {
		return this.exit;
	}
}
