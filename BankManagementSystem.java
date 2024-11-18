import java.util.Scanner;
import java.util.HashMap;

class Account {
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    public Account(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

public class BankManagementSystem {
    private static HashMap<Integer, Account> accounts = new HashMap<>();
    private static int accountCounter = 1001; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Bank Management System!");
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter account holder name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        int accountNumber = accountCounter++;
        Account newAccount = new Account(name, accountNumber);
        accounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            accounts.get(accountNumber).deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            accounts.get(accountNumber).withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Current Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}
