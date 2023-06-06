package example.models;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionType;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    // Add getters as needed
}
