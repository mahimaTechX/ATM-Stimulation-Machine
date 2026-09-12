package service;
import model.BankAccount;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import exception.InsufficientBalanceException;
public  class ATM {
    private ATMService atmService;
    Scanner sc = new Scanner(System.in);
    BankAccount account;
    public ArrayList<BankAccount> accounts;
   public ATM(ArrayList<BankAccount> accounts)
   {
this.accounts = accounts;
this.atmService= new ATMService();
    }
public static final int CHECK_BALANCE = 1;
public static final int DEPOSIT = 2;
public static final int WITHDRAW = 3;
public static final int CHANGE_PIN = 4;
public static final int ACCOUNT_DETAILS =5;
public static final int TRANSACTION_HISTORY = 6;
public static final int MINI_STATEMENTS = 7;
public static final int TRANSFER_MONEY = 8;
public static final int LOG_OUT = 9;
    void printReceipt(String transactionType, double amount){
        System.out.println("============ATM RECEIPT============");
        System.out.println("Account Holder :"+ account.getaccountHolderName());
                System.out.println("Account Number :"+account.getAccountNumber());
                System.out.println("Transaction  "+transactionType);
                System.out.println("Amount :"+amount);
                System.out.println("Balance"+ account.getBalance());
                System.out.println("Date and time :"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println("====================================");
        System.out.println("Thank you for using our ATM!");
               System.out.println("====================================");
            }
   public void login(){
        System.out.println("==========ATM==========");
        System.out.println("Enter your account number: ");
        long enteredAccountNumber = sc.nextLong();
        BankAccount foundAccount = atmService.findAccount(accounts, enteredAccountNumber);
        if(foundAccount==null){
            System.out.println("Account not found");
            return;
        }
        this.account = foundAccount;
        System.out.println("Account found!");
        int attempts =4;
        do{
        System.out.println("Enter your PIN");
        int enteredPin = sc.nextInt();
        if(account.verifyPin(enteredPin)){
            showMenu();
        }
        else{
            System.out.println("Incorrect pin");
            attempts--;
            System.out.println("only "+attempts+"attempt(s) left"); 
        }
    }while(attempts!=0);
    System.out.println("Too many incorrect attempts");
    System.out.println("Your account has temporarily blocked");
}
 void showMenu() {
    while(true){
        int choice=0;
        try{
System.out.println("================ATM===============");
System.out.println("1.  Check Balance");
System.out.println("2.  Deposit");
System.out.println("3.  Withdraw");
System.out.println("4.  Change Pin");
System.out.println("5.  Account Details");
System.out.println("6.  Transaction History");
System.out.println("7.  Mini Statements");
System.out.println("8.  Transfer money");
System.out.println("9.  Log out");
System.out.println("==================================");
System.out.println("Enter your choice:"); 
    choice = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Invalid input. Please enter a valid choice");
            sc.nextLine();
            continue;
        }
switch(choice){
    case CHECK_BALANCE:
        account.checkBalance();
        break;
        case DEPOSIT:
            try{
            System.out.println("Enter the amount you want to deposit");
            long amount = sc.nextInt();
            account.deposit(amount);
            printReceipt("CASH DEPOSIT", amount);
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid amount");
                sc.nextLine();
            }
            break;
            case WITHDRAW:
                try{
                System.out.println("Choose the amount to withdraw");
                fastcash();
                }catch(InsufficientBalanceException e){
                    System.out.println("Transaction failed"+ e.getMessage());
                }
                 break;
                case CHANGE_PIN:
                    System.out.println("Enter your old pin");
                    int oldpin = sc.nextInt();
                    System.out.println("Enter your new pin");
                    int newpin = sc.nextInt();
                    account.changePin(oldpin,newpin );
                    break;
                    case ACCOUNT_DETAILS:
                        account.displayAccountDetails();
                        break;
                        case TRANSACTION_HISTORY:
                            account.transactionhistory();
                            break;
                            case MINI_STATEMENTS:
                                account.ministatements();
                                break;
                                case TRANSFER_MONEY:
                                    System.out.println("Enter receiver account number");
                                    long receiverNumber = sc.nextLong();
                                    BankAccount receiver = null;
                                    for(BankAccount acc : accounts){
                                        if(acc.getAccountNumber()==receiverNumber){
                                            receiver = acc;
                                            break;
                                        } 
                                        if(receiver==null){
                                            System.out.println("Receiver account not found");
                                            break;
                                        }
                                        if(receiver==account){
                                            System.out.println("You cannot transfer money to your own account");
                                        break;
                                        }
                                        System.out.println("Enter the amount to transfer");
                                        double amount = sc.nextDouble();
                                        try{
                                            account.transferTo(receiver, amount);
                                        }catch(InsufficientBalanceException e){
                                            System.out.println(e.getMessage());
                                        }
                                        printReceipt("AMOUNT TRANSFER", amount);
                                        break;   
                                    }
                                case LOG_OUT:
                        System.out.println("You have been logged out successfully");
                        return;
                        default:
                            System.out.println("Invalid choice , Please try again");
                            break;

}
    }
}
void fastcash() throws InsufficientBalanceException{
    System.out.println("===============FAST CASH================");
    System.out.println("1.  500");
    System.out.println("2.  1000");
    System.out.println("3.  2000");
    System.out.println("4.  5000");
    System.out.println("5.  10000");
    System.out.println("6.  Back");
    System.out.println("Enter your choice");
   int enter=0;
    try{
    enter = sc.nextInt();
    }catch(InputMismatchException e){
        System.out.println("Invalid input. Please enter a valid choice");
        sc.nextLine();
        fastcash();
    }
    switch(enter){
         case 1:
            account.withdraw(500);
            printReceipt("CASH WITHDRAWL", 500);
            break;
            case 2 :
                account.withdraw(1000);
                printReceipt("CASH WITHDRAWL", 1000);
                break;
                case 3:
                    account.withdraw(2000);
                    printReceipt("CASH WITHDRAWL", 2000);
                    break;
                    case 4:
                        account.withdraw(5000);
                        printReceipt("CASH WITHDRAWL", 5000);
                        break;
                        case 5:
                            account.withdraw(10000);
                            printReceipt("CASH WITHDRAWL", 10000);
                            break;
                            case 6:
                            showMenu();
                            break;
                            default:
                                System.out.println("Invalid choice");
                                break;

    }

}
}