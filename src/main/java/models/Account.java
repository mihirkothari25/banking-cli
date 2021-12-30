package models;

public class Account {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final String phoneNumber;
    private final String pin;
    private double balance;

    public Account(String firstName, String lastName, String email, String address, String phoneNumber, String pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.pin = pin;
        balance = 0.0;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double withdraw) {
        if (withdraw > this.balance) {
            System.out.println("Insufficient funds.");
        } else {
            this.balance -= withdraw;
            System.out.println("You have successfully withdrawn $" + withdraw + " from your account.");
            System.out.println("Your new balance is: $" + this.balance);
        }
    }

    public void deposit(double deposit) {
        this.balance += deposit;
        System.out.println("You have successfully deposited $" + deposit + " into your account.");
        System.out.println("Your new balance is: $" + this.balance);
    }
}
