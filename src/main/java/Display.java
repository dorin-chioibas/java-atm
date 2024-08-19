package src.main.java;

public class Display {
    public static void showStartMenu() {
        System.out.println("Welcome to Java ATM app. Please select your option: \n");
        System.out.println("1. Enter account name\n2. Exit\n");
    }

    public static void showOperationsMenu() {
        System.out.println("Select operation:\n");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Exit");
    }

    public static void enterAccountName() {
        System.out.println("Enter account name: \n");
    }

    public static void loggedInAs(String name) {
        System.out.println("Logged in as " + name + "\n");
    }

    public static void moneyDeposit() {
        System.out.println("How much money would you like to deposit?\n");
    }

    public static void moneyWithdraw() {
        System.out.println("How much money would you like to withdraw?\n");
    }

    public static void accountCreated() {
        System.out.println("Account created!\n");
    }

    public static void createNewAccountMenu(String name) {
        System.out.println("Account does not exist. Do you want to create a new account with the name: " + name + " ?\n");
        System.out.println("1. Yes\n2. No\n");
    }

    public static void balance(Double balance) {
        System.out.println("Your balance is: " + balance);
    }

    public static void successDeposit() {
        System.out.println("The money has been deposited.");
    }

    public static void successWithdrawal() {
        System.out.println("The money has been withdrawn.");
    }

    static class Errors {
        public static void invalidOptionError() {
            System.out.println("Invalid option. Please select a valid option.\n");
        }

        public static void insufficientFunds() {
            System.out.println("Insufficient funds!\n");
        }

        public static String invalidValidIntegerInput() {
            return "Invalid input. Please enter a number.";
        }

        public static String invalidValidDoubleInput() {
            return "Invalid input. Please enter a valid double.";
        }
    }
}
