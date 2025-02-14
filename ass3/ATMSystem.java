import java.util.Scanner;

class ATM {
    private int correctPIN = 1234;
    private double balance = 3000;

    public void withdraw(double amount, int enteredPIN) throws Exception {
        if (enteredPIN != correctPIN) {
            throw new SecurityException("Error: Invalid PIN.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Error: Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Current Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        try {
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();

            atm.withdraw(amount, pin);

        } catch (SecurityException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            System.out.println("Remaining Balance: " + atm.getBalance());
            scanner.close();
        }
    }
}
