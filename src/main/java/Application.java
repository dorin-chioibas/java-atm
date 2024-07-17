package src.main.java;

import java.util.Scanner;

public class Application {
	private ATM atm = new ATM();
	private boolean exit = false;
	private Scanner scan = new Scanner(System.in);
	
	public Application() {
		startMenuRunning();
	}
	
	public void startMenuRunning() {
		while(!this.exit) {
			Display.menu();
			var name = scan.nextLine();
			if(name.equals("e")){
				exit();	
				break;		
			}
			var account = this.accountSearch(name);
			if(account != null) {
				runningAccount(account);	
			}
		}
		scan.close();
		Display.endOfSession();
	}
	
	
	private ATMaccount accountSearch(String name) {
		if(atm.hasAccount(name)) {
			var account = atm.getAccountUser(name);
			account.open();
			return account;
		}
		return makeAccount(name);
	}
	
	/**
	 * creates a new account
	 */
	private ATMaccount makeAccount(String name) {
		Display.makeAccount();
		int choice = intScan();
		if (choice == 0) {
			return null;
		}
		if (choice == 1) {
			return atm.makeAccount(name);
		}
		ErrorHandling.invalidOption();
		return null;
	}
	
	
	public void runningAccount(ATMaccount account) {
		Display.welcome(account.getUser().getName());
		while(!account.isClosed()) {
			Display.accountMenu(account);
			atmWork(account, intScan());
		}
		Display.endOfSession(account.getUser().getName());
		startMenuRunning();

	}
	
	public void exit() {
		this.exit= true;
	}
	
	private void atmWork(ATMaccount account,int choice) {
		switch(choice) {
		case 1:
			Display.balance(account.checkBalance());
			break;
		case 2:
			account.depositMoney(giveMoney());
			Display.balance(account.checkBalance());
			break;
		case 3:
			account.withdrawMoney(giveMoney());
			Display.balance(account.checkBalance());
			break;
		case 4:
			account.close();
			break;
		default:
			ErrorHandling.invalidOption();
		}
		
	}
	
	private float giveMoney() {
		Display.giveMoney();
		return floatScan();
	}
	
	private int intScan() {
		int integer =  scan.nextInt();
		scan.nextLine(); 
		return integer;
	}
	private float floatScan() {
		float moneyToDeposit = scan.nextFloat();
		scan.nextLine();
		return moneyToDeposit;
	}

}
