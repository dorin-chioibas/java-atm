package src.main.java;

public class Display {

	public static void Menu() {
		System.out.println("Welcome ! What is your account's name ?");
	}
	
	public static void accountMenu(ATMaccount account) {
        System.out.println("Please select an option:");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
	}
}
