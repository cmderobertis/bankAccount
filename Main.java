public class Main {
    public static void main(String[] args) {
        BankAccount b = new BankAccount(400, 400);
        System.out.printf("Total: $%.2f\n", b.getTotalMoney());
        System.out.println(b.getAccountNumber());
        b.withdraw("checking", 500);
        b.deposit("savings", 600);
        double savingsBalance = b.getSavingsBalance();
        System.out.printf("Savings: $%.2f\n", savingsBalance);
    }
}
