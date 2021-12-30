package models;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bank {
    private final Map<String, Account> accounts;
    private final Scanner sc;

    public Bank() {
        accounts = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void newAccount() {
        // Input first name
        System.out.println("First name:");
        String firstName = sc.next();

        // Input last name
        System.out.println("Last name:");
        String lastName = sc.next();

        // Input email
        String email = enterEmail();

        // Input address
        System.out.println("Address:");
        String address = sc.next();

        // Input phone number
        boolean validPhoneNumber = false;
        String phoneNumber = "";
        while (!validPhoneNumber) {
            System.out.println("Phone number:");
            phoneNumber = sc.next();
            if (validatePhoneNumber(phoneNumber)) {
                validPhoneNumber = true;
            } else {
                System.out.println("Please enter a valid 10 digit phone number.");
            }
        }

        // Input pin and validate it's 4 digits.
        String pin = enterPin();

        // Create new account and add it to the list of accounts the bank maintains.
        // In this application we are storing the accounts in memory, but in a more flushed out solution this would be done in a database.
        accounts.put(email, new Account(firstName, lastName, email, address, phoneNumber, pin));
        System.out.println("Your account was created!");
    }

    public void login() {
        if (accounts.size() < 1) {
            System.out.println("No accounts!");
            return;
        }
        String email = enterEmail();
        String pin = enterPin();
        Account account = lookupAccount(email, pin);
        if (account != null) {
            boolean loggedIn = true;
            while(loggedIn) {
                loggedInOptions();
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        // display balance
                        System.out.println("Your balance is: $" + account.getBalance());
                        break;
                    case 2:
                        // deposit money
                        System.out.println("Please enter the amount you would like to deposit.");
                        double deposit = sc.nextDouble();
                        account.deposit(deposit);
                        break;
                    case 3:
                        // withdraw money
                        System.out.println("Please enter the amount you would like to withdraw.");
                        double withdraw = sc.nextDouble();
                        account.withdraw(withdraw);
                        break;
                    case 4:
                        loggedIn = false;
                        break;
                    default:
                        System.out.println("Please select a valid option.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid email or pin. Please try again.");
        }
    }

    private String enterEmail() {
        // Input email
        boolean validEmail = false;
        String email = "";
        while (!validEmail) {
            System.out.println("Email:");
            email = sc.next();
            if (validateEmail(email)) {
                validEmail = true;
            } else {
                System.out.println("Email is not valid. Please enter a valid email.");
            }
        }
        return email;
    }

    private String enterPin() {
        boolean validPin = false;
        String pin = "";
        while (!validPin) {
            System.out.println("Enter a 4 digit PIN:");
            pin = sc.next();
            if (validatePin(pin)) {
                validPin = true;
            } else {
                System.out.println("Please enter a valid 4 digit pin.");
            }
        }
        return pin;
    }

    private static boolean validatePin(String pin) {
        return Pattern.compile("\\d{4}").matcher(pin).matches();
    }

    private static boolean validatePhoneNumber(String phoneNumber) {
        return Pattern.compile("\\d{10}").matcher(phoneNumber).matches();
    }

    private boolean validateEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    private Account lookupAccount(String email, String pin) {
        if (accounts.containsKey(email) && accounts.get(email).getPin().equals(pin))  {
            return accounts.get(email);
        }
        return null;
    }

    private static void loggedInOptions() {
        System.out.println("Welcome:");
        System.out.println("\r" + "1. Show balance?");
        System.out.println("\r" + "2. Deposit money?");
        System.out.println("\r" + "3. Withdraw money?");
        System.out.println("\r" + "4. Logout?");
    }
}
