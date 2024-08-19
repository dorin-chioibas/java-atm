package src.main.java;

public class User {
    private final String name;
    private Double balance;

    public User(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public boolean checkWithdrawPossible(double withdrawMoney) {
        return withdrawMoney <= balance;
    }
}
