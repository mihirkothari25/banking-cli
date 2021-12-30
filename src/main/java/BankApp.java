import models.Bank;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        boolean endSession = false;
        while (!endSession) {
            initialOptions();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bank.newAccount();
                    break;
                case 2:
                    bank.login();
                    break;
                case 3:
                    endSession = true;
                    break;
                default:
                    System.out.println("Please select a valid option.");
                    break;
            }
        }
    }

    private static void initialOptions() {
        System.out.println("Welcome:");
        System.out.println("\r" + "1. Open a new account?");
        System.out.println("\r" + "2. Log in to an existing account?");
        System.out.println("\r" + "3. Exit?");
    }
}
