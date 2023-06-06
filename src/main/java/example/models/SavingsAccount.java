package example.models;

public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 1000.00;

    public SavingsAccount(String accountNumber, String accountHolderName) {
        super(accountNumber, accountHolderName);
        balance = MIN_BALANCE;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            saveTransaction("Withdrawal", -amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}
