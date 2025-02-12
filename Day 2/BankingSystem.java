import java.util.*;

public class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>(); // Account Storage
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>(); // Sort by balance
    private Queue<Integer> withdrawalQueue = new LinkedList<>(); // FIFO Withdrawal Requests

    // Create an account
    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Deposit money
    public void deposit(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        double newBalance = accounts.get(accountNumber) + amount;
        sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
        accounts.put(accountNumber, newBalance);
        sortedAccounts.put(newBalance, accountNumber); // Add updated balance
    }

    // Request a withdrawal (adds to queue)
    public void withdraw(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        withdrawalQueue.add(accountNumber);
        System.out.println("Withdrawal request added for account: " + accountNumber);
    }

    // Process withdrawal requests
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll(); // Get next request
            double amount = 50.0; // Example withdrawal amount (change as needed)

            if (accounts.get(accountNumber) >= amount) {
                double newBalance = accounts.get(accountNumber) - amount;
                sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
                accounts.put(accountNumber, newBalance);
                sortedAccounts.put(newBalance, accountNumber); // Add updated balance
                System.out.println("Withdrawn $" + amount + " from Account " + accountNumber);
            } else {
                System.out.println("Insufficient balance in Account " + accountNumber);
            }
        }
    }

    // Get sorted accounts by balance
    public Map<Double, Integer> getSortedAccountsByBalance() {
        return sortedAccounts;
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Create accounts
        bank.createAccount(101, 500.0);
        bank.createAccount(102, 1000.0);
        bank.createAccount(103, 750.0);

        // Deposit money
        bank.deposit(101, 200.0);

        // Request withdrawals
        bank.withdraw(102, 50.0);
        bank.withdraw(103, 50.0);

        // Process withdrawals
        bank.processWithdrawals();

        // Display sorted accounts by balance
        System.out.println("Accounts Sorted by Balance: " + bank.getSortedAccountsByBalance());
    }
}
