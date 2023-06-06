package example.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private String accountNumber;
    private String accountHolderName;
    protected double balance;
    protected List<Transaction> transactionHistory;

    public Account(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.transactionHistory = new ArrayList<>();
    }

    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        balance += amount;
        saveTransaction("Deposit", amount);
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    protected void saveTransaction(String transactionType, double amount) {
        Transaction transaction = new Transaction(transactionType, amount);
        transactionHistory.add(transaction);
    }
}
