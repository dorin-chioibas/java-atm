package src.main.java;

import java.util.Scanner;

public class Application {
	private ATM atm = new ATM(this);
	private boolean exit = false;
	private Scanner scan = new Scanner(System.in);
	
	public Application() {
		startmenuRunning();
	}
	
	public void startmenuRunning() {
		while(!this.exit) {
			Display.menu();
			var name = scan.nextLine();
			var account = atm.getAccountUser(name);
			if(account != null) {
				runningAccount(account);
			}
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
		startmenuRunning();

	}
	
	public void exit() {
		this.exit= true;
	}
	
	private void atmWork(ATMaccount atm,int choice) {
		switch(choice) {
		case 1:
			System.out.println("Balance of the account");
			System.out.println(atm.checkBalance());
			break;
		case 2:
			System.out.println("Give money to deposit");
			float moneyToDeposit = scan.nextFloat();
			atm.depositMoney(moneyToDeposit);
			System.out.println("Balance of the account");
			System.out.println(atm.checkBalance());
			break;
		case 3:
			System.out.println("Give money to deposit");
			float moneyToDraw = scan.nextFloat();
			atm.withdrawMoney(moneyToDraw);
			System.out.println("Balance of the account");
			System.out.println(atm.checkBalance());
			break;
		case 4:
			atm.close();
			break;
		default:
			ErrorHandling.invalidOption();
		}
		
	}
	public ATMaccount makeAccount(String name,ATM account) {
		System.out.println("Do you want to make an account(0/1)");
		int choice = scan.nextInt();
		scan.nextLine(); // Consume the newline left-over
		if (choice == 0) {
			return null;
		}

		if (choice == 1) {
			var user = new User(name);
			account.addAccount(user.getAccount(), name);
			return user.getAccount();
		}

		ErrorHandling.invalidOption();
		return null;
		
	}
}
