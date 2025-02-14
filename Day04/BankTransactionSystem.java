package com.capgeminitraining.day4;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {

        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {

        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public double getBalance() {

        return balance;
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100); // Initial balance

        try {
            account.withdraw(200); // Attempting to withdraw more than balance
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {//if withdraw amount is negative
            System.out.println(e.getMessage());
        }
    }
}
