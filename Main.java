import java.util.ArrayList;
import service.ATM;
import model.BankAccount;
import java.util.*;
public class  Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        BankAccount account1 = new BankAccount( 
             1234567890L,
            "Mahima",
            5000,
            1234 
        );
        BankAccount account2 = new BankAccount( 
             1111111111L,
            "yachana",
            500,
            2208
        );
BankAccount account3 = new BankAccount( 
             2222222222L,
            "Isha",
            2000,
            1607
            
        );
        BankAccount account4 = new BankAccount( 
             3333333333L,
            "Prashant",
            100,
            2012
        );
        BankAccount account5 = new BankAccount( 
             4444444444L,
            "Harshit",
            5000,
            4002
        );
         ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);
        ATM atm = new ATM(accounts);
        while(true){
        atm.login();
        System.out.println("\n Would you like another user to login");
        System.out.println("1. Yes");
        System.out.println("2. Exit");
        int choice = sc.nextInt();
        if(choice==2){
            System.out.println("ATM shutting down......");
            break;
        }
    }
    sc.close();
}
}
