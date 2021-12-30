# Banking CLI App

This is a simple CLI app that simulates a bank. A user is able to create an account, 
log into the account, display their balance, deposit money and withdraw money.

# Pre-requistes

The following components will have to be installed before running the application -
1. Java (8+)
2. Maven (3.8.1+)

# Installation
To run this application, run the following command from the root of the repository, from the command
line -


```bash
mvn compile exec:java -Dexec.mainClass="BankApp"
```

Alternatively this app can also be imported into an IDE like IntelliJ and the BankApp class can be run via the IDE.

# Usage

Use the numbers next the options and then press enter, to determine which workflow needs to be executed.
The user can -
1. Open an account.
2. Log into an existing account.
3. Once logged into an existing account, a user can deposit money.
4. Once logged into an existing account, a user can withdraw money.
5. The user can exit and end the session.