package src.main.java;

public class Application {
    ScannerUtils scannerUtils = new ScannerUtils();

    public void start() {

        Display.showStartMenu();
        var isFlowActive = true;
        while (isFlowActive) {
            var accountOrExitChoice = scannerUtils.getValidIntegerInput();
            switch (accountOrExitChoice) {
                case 1 -> {
                    Display.enterAccountName();
                    var name = scannerUtils.getStringInput();
                    if (Database.users.containsKey(name.hashCode())) {
                        loggedInUserFlow(name);
                    } else {
                        createAndLogInUserFlow(name);
                    }

                    Display.showStartMenu();
                }
                case 2 -> isFlowActive = false;
                default -> {
                    Display.Errors.invalidOptionError();
                    Display.showStartMenu();
                }
            }
        }
    }

    private void createAndLogInUserFlow(String name) {
        Display.createNewAccountMenu(name);

        var choice = scannerUtils.getValidIntegerInput();
        handleUserChoice(choice, name);
    }

    private void handleUserChoice(int choice, String name) {
        var isFlowActive = true;
        while (isFlowActive) {
            switch (choice) {
                case 1 -> {
                    createUserAccountFlow(name);
                    isFlowActive = loggedInUserFlow(name);
                }
                case 2 -> isFlowActive = false;
                default -> {
                    Display.Errors.invalidOptionError();
                    choice = scannerUtils.getValidIntegerInput();
                }
            }
        }
    }

    private void createUserAccountFlow(String name) {
        Database.users.put(name.hashCode(), new User(name, 0d));
        Display.accountCreated();
    }


    private boolean loggedInUserFlow(String name) {
        Display.loggedInAs(name);
        var currentUser = Database.users.get(name.hashCode());
        var showLoginOperationFlow = true;
        while (showLoginOperationFlow) {
            Display.showOperationsMenu();
            var operation = scannerUtils.getValidIntegerInput();
            showLoginOperationFlow = handleOperation(operation, currentUser);
        }
        return false;
    }

    private boolean handleOperation(int operation, User currentUser) {
        switch (operation) {
            case 1 -> handleCheckBalance(currentUser);
            case 2 -> handleDeposit(currentUser);
            case 3 -> handleWithdrawal(currentUser);
            case 4 -> {
                return false;
            }
            default -> Display.Errors.invalidOptionError();
        }
        return true;
    }

    private static void handleCheckBalance(User currentUser) {
        Display.balance(currentUser.getBalance());
    }

    private void handleDeposit(User currentUser) {
        Display.moneyDeposit();
        var depositMoney = scannerUtils.getValidDoubleInput();
        currentUser.setBalance(currentUser.getBalance() + depositMoney);
        Display.successDeposit();
    }

    private void handleWithdrawal(User currentUser) {
        Display.moneyWithdraw();
        var withdrawMoney = scannerUtils.getValidDoubleInput();
        if (currentUser.checkWithdrawPossible(withdrawMoney)) {
            currentUser.setBalance(currentUser.getBalance() - withdrawMoney);
            Display.successWithdrawal();
        } else {
            Display.Errors.insufficientFunds();
        }
    }
}
