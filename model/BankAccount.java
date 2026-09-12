package model;
import java.util.ArrayList;
import exception.InsufficientBalanceException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class BankAccount{
    //declaring the instance variables of the class
private long accountNumber;
private String accountHolderName;
private double balance;
int pin;
//now using constructor to initialize the values of the instance variables
//constructor is a special type of method which is used to initialize the instance variables of the class
//constructor name should be same as class name and it should not have any return type
//constructor overloading is also possible in java
public BankAccount(long accountNumber, String accountHolderName, double balance, int pin ){
    this.accountNumber = accountNumber;
    this.accountHolderName= accountHolderName;
    this.balance = balance;
    this.pin = pin;
}
public static final int MIN_PIN =1000;
public static final int MAX_PIN = 9999;
public long getAccountNumber(){
    return accountNumber;
}
public String getaccountHolderName(){
return accountHolderName;
}
public double getBalance(){
    return balance;
}
public void checkBalance(){
System.out.println("Current Balance :"+ balance);
}
public void deposit(double amount){
  if(amount <=0){
    System.out.println("Invalid amount. Amouont should be greater than zero");
  }
  else{
    transactionhistory.add(new Transaction("DEPOSIT", amount));
    balance = balance + amount;
    System.out.println("Rupee  "+amount+"  Deposited Successfully  -"+datetime);
    System.out.println("Updated balance:"+balance);
  }
}
private double dailyWithdrawLimit = 20000;
 double withdrawnToday =0;
public void withdraw(double amount) throws InsufficientBalanceException {
    if(amount <=0){
        System.out.println("Invalid amount. Amount should be greater than zero");
        return;
    }
    if(amount>balance){
    throw new InsufficientBalanceException("Your Bank balance has insufficient amount");
    }
    if(withdrawnToday + amount>dailyWithdrawLimit){
        System.out.println("Daily Withdrawn limit exceeded");
        System.out.println("Remaining limit: "+(dailyWithdrawLimit- withdrawnToday));
      return;   
    }  
balance -= amount;
withdrawnToday = withdrawnToday+ amount;
transactionhistory.add(new Transaction("WITHDRAWL", amount));  
System.out.println("Your amount has been debited succefully. Please collect your amount");
System.out.println(datetime);
System.out.println("Remaining balance :"+ balance);
}
public boolean verifyPin(int enteredPin){
    if(enteredPin<MIN_PIN||enteredPin>MAX_PIN){
        System.out.println("Invalid pin. Pin should be 4 digit number");
        return false;
    }
    else{
    if (enteredPin==pin){
        return true;
    }
    else{
        return false;
    }
}
}
public void changePin(int oldpin, int newpin){
    if(newpin<MIN_PIN||newpin>MAX_PIN){
        System.out.println("Invalid pin. Pin should be 4 digit number");
    }
    else{
    if(oldpin == pin){
        pin = newpin;
        System.out.println("pin changed successfully");
    }
    else{
        System.out.println("Caution!   Wrong pin entered:");
    }
}
}
public void displayAccountDetails(){
    System.out.println("AccountNumber: "+accountNumber);
    System.out.println("Account Holder: "+accountHolderName);
    System.out.println("Balance: "+balance);
}
public ArrayList<Transaction> transactionhistory = new ArrayList<>();
public void transactionhistory(){
if(transactionhistory.isEmpty()){
    System.out.println("No Transaction History is Found");
}
else{
    System.out.println("====================Transaction History");
    System.out.println("====================");
    for(Transaction transaction : transactionhistory ){
        System.out.println(transaction);
    }
    System.out.println("========================================");
    System.out.println("=====================");
}
}
public void ministatements(){
    System.out.println("=========================================");
    System.out.println("            MINI STATEMENT               ");
    System.out.println("==========================================");
    displayAccountDetails();
    System.out.println("Date & Time: " + datetime);
    System.out.println("Recent Transactions");
    System.out.println("-------------------------------------------");
    transactionhistory();
    System.out.println("                                            ");
    System.out.println("Thank You For Banking With Us");
    System.out.println("============================================");
    
}
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
LocalDateTime now = LocalDateTime.now();
String datetime = now.format(dtf);
public void transferTo(BankAccount receiver, double amount) throws InsufficientBalanceException{
    if(amount<= 0){
        System.out.println("Invalid transfer amount");
        return;
    }
    if(amount>balance) {
        throw new InsufficientBalanceException("Insufficient balance for this transfer");
}
balance -= amount;
receiver.balance += amount;
transactionhistory.add(new Transaction("TRANSFER", amount));
receiver.transactionhistory.add(new Transaction("RECEIVED", amount));
System.out.println(amount+"Transferred successfully");
System.out.println("Remaining Balance"+balance);
}
}

