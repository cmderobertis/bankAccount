import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private long accountNumber;
    private static int numAccounts = 0;
    private double totalMoney = 0.0;
    Random rand = new Random();
    long getRandomAccountNumber() {
        int firstHalf =  rand.nextInt(90000) + 10000;
        int secondHalf =  rand.nextInt(90000) + 10000;
        return (long)firstHalf * 100000 + (long)secondHalf;
    }

    //Constructor
    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.totalMoney = checkingBalance + savingsBalance;
        this.accountNumber = getRandomAccountNumber();
        numAccounts++;
    }

    public void deposit(String accountType, double amount) {
        switch (accountType) {
            case "checking":
                this.checkingBalance += amount;
                totalMoney += amount;
                break;
            case "savings":
                this.savingsBalance += amount;
                totalMoney += amount;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + accountType);
        }
    }

    public void withdraw(String accountType, double amount) {
        switch (accountType) {
            case "checking":
                if (amount <= this.checkingBalance) {
                    this.checkingBalance -= amount;
                    totalMoney -= amount;
                } else {
                    System.out.println("Insufficient funds");
                }
                break;
            case "savings":
                if (amount <= this.savingsBalance) {
                    this.savingsBalance -= amount;
                    totalMoney -= amount;
                } else {
                    System.out.println("Insufficient funds");
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + accountType);
        }
    }

    //Getters and setters
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
}
