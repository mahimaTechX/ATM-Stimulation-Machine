# 🏦 ATM Simulation Machine

A console-based ATM Simulation Machine developed in Java to demonstrate Object-Oriented Programming, Collections, Exception Handling, Modular Architecture, and real-world banking operations.

This project started as a basic ATM simulation and was progressively enhanced with multiple accounts, authentication, transaction management, money transfer, custom exceptions, and a structured package architecture.

---

## 📌 Project Overview

The ATM Simulation Machine provides a realistic console-based banking experience where users can:

- Log in using an account number and PIN
- Check account balance
- Deposit money
- Withdraw money
- Use Fast Cash
- Change PIN
- View account details
- View transaction history
- Generate a mini statement
- Transfer money between accounts
- Generate transaction receipts
- Log out securely

The project focuses on applying Java concepts to a practical real-world application rather than only implementing isolated programs.

---

## ✨ Features

### 🔐 Authentication & Security
- Account number-based login
- PIN authentication
- Limited PIN attempts
- Account locking after failed attempts
- Secure logout/session handling

### 💰 Banking Operations
- Balance inquiry
- Deposit money
- Withdraw money
- Fast Cash
- Daily withdrawal limit
- Change PIN
- Money transfer between accounts

### 📊 Transaction Management
- Transaction history
- Mini statement
- Transaction date and time
- Transaction types and amounts
- Receipt generation

### ⚠️ Validation & Exception Handling
- Invalid input validation
- Insufficient balance handling
- Custom InsufficientBalanceException
- PIN validation
- Withdrawal-limit validation
- Account validation

### 🧱 Project Architecture
The project follows a modular package structure:

- model → Represents application data
- service → Contains ATM/business logic
- exception → Contains custom exceptions

---

## 🛠️ Technologies Used

- *Java*
- Object-Oriented Programming
- Java Collections Framework
- ArrayList
- Exception Handling
- Custom Exceptions
- Java Date & Time API
- Packages
- Encapsulation
- Inheritance/Polymorphism concepts where applicable
- VS Code

---

## 📂 Project Structure

```text
ATM Simulation Machine
│
├── Main.java
│
├── model
│   ├── BankAccount.java
│   └── Transaction.java
│
├── service
│   ├── ATM.java
│   └── ATMService.java
│
└── exception
    └── InsufficientBalanceException.java