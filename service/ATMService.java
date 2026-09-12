package service;
import java.util.ArrayList;
import model.BankAccount;
//import exception.InsufficientBalanceException;
public class ATMService {
  public BankAccount findAccount(
    ArrayList<BankAccount> accounts, long accountNumber){
for(BankAccount account : accounts){
    if (account.getAccountNumber()==accountNumber){
        return account;
    }
}
return null;
    }
  }   

