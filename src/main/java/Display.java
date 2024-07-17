package src.main.java;

public class Display {

	public static void menu() {
		System.out.println("Welcome ! What is your account's name ? or press e to exit");
	}
	
	public static void welcome(String name) {
		System.out.println("Welcome " + name);
	}
	public static void accountMenu(ATMaccount account) {
        System.out.println("Please select an option:");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
	}
	
	public static void endOfSession() {
		System.out.println("End of the session");
	}
	
	public static void endOfSession(String name) {
		System.out.println("End of the session of " + name);
	}
	
	public static void balance(float f) {
		System.out.println("Balance of the account");
		System.out.println(f);
	}
	
	public static void giveMoney() {
		System.out.println("Give money to deposit");
	}
	
	public static void makeAccount() {
		System.out.println("Do you want to make an account(0/1)");
	}
}
