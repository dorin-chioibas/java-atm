package src.main.java;

import java.util.Scanner;

public class Application {
	private ATM atm = new ATM(this);
	private boolean exit = false;
	private Scanner scan = new Scanner(System.in);
	
	public Application() {
		StartMenuRunning();
	}
	
	public void StartMenuRunning() {
		while(!this.exit) {
			Display.Menu();
			String name = scan.nextLine();
			ATMaccount account = atm.getAccountUser(name);
			if(account != null) runningAccount(account);
		}
		scan.close();
		System.out.println("End Of the Session");
	}
	
	public void runningAccount(ATMaccount account) {
		System.out.println("Welcome " + account.getUser().getName());
		while(!account.isClosed()) {
			Display.accountMenu(account);
			int choice = scan.nextInt();
			atmWork(account, choice);
		}
		System.out.println("End Of the Session of " + account.getUser().getName());
		scan.nextLine();
		StartMenuRunning();

	}
	
	public void exit() {
		this.exit= true;
	}
	
	private void atmWork(ATMaccount atm,int choice) {
		switch(choice) {
		case 1:
			System.out.println("Balance of the account");
			System.out.println(atm.CheckBalance());
			break;
		case 2:
			System.out.println("Give money to deposit");
			float moneyToDeposit = scan.nextFloat();
			atm.DepositMoney(moneyToDeposit);
			System.out.println("Balance of the account");
			System.out.println(atm.CheckBalance());
			break;
		case 3:
			System.out.println("Give money to deposit");
			float moneyToDraw = scan.nextFloat();
			atm.WithdrawMoney(moneyToDraw);
			System.out.println("Balance of the account");
			System.out.println(atm.CheckBalance());
			break;
		case 4:
			atm.close();
			break;
		default:
			ErrorHandling.InvalidOption();
		}
		
	}
	public ATMaccount makeAccount(String name,ATM account) {
		System.out.println("Do you want to make an account(0/1)");
		int choice = scan.nextInt();
		scan.nextLine(); // Consume the newline left-over
		if(choice == 0) {
			return null;
		}
		else if(choice == 1) {
			User user = new User(name);
			account.addAccount(user.getAccount(), name);
			return user.getAccount();
		}
		else {
			ErrorHandling.InvalidOption();
			return null;
		}
		
	}
}
