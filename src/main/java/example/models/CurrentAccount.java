package example.models;

public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 100000.00;

    public CurrentAccount(String accountNumber, String accountHolderName) {
        super(accountNumber, accountHolderName);
    }

    @Override
    public void withdraw(double amount) {
        double availableBalance = balance + OVERDRAFT_LIMIT;
        if (amount <= availableBalance) {
            balance -= amount;
            saveTransaction("Withdrawal", -amount);
        } else {
            System.out.println("Exceeded available balance");
        }
    }
}
