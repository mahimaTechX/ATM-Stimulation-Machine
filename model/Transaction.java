package model;
import java.time.LocalDateTime;
public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime dateTime;
    public Transaction(String type, double amount){
        this.amount = amount;
        this.type = type;
        this.dateTime = LocalDateTime.now();
    } 
public String getType(){
    return type;
}
public double getamount(){
    return amount;
}
public LocalDateTime getdatetime(){
    return dateTime;
}
@Override
public String toString(){
    return "type: "+type+ "| Amount :"+amount+"|  Date & Time "+ dateTime;
}
}