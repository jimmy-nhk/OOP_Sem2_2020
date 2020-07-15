package Wk3;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private String name ;
    private int id = 0 ;
    private double balance = 0 ;
    private static double annualInterestRate = 0 ;
    private Date dateCreated ;
    // private ArrayList<Transaction> transactions ;

//    public ArrayList<Transaction> getTransactions() {
//        return transactions;
//    }



    public Account(int id , double balance , String name) {
        this.id = id ;
        this.balance = balance ;
        this.name = name ;
        // this.transactions = new ArrayList<Transaction>() ;
        dateCreated = new Date () ;
    }

    // Get the accessors and mutators for the class
    public  int getId () {
        return this.id ;
    }


    public  double getBalance () {
        return  this.balance ;
    }

    public  double getAnnualInterestRate () {
        return this.annualInterestRate ;
    }

    public  String getDate () {
        return this.dateCreated.toString() ;
    }

    public void setId (int id){
        this.id = id ;
    }

    public void setBalance ( double balance) {
        this.balance = balance ;
    }

    public void setAnnual ( double annualInterestRate) {
        this.annualInterestRate = annualInterestRate / 100 ;
    }

    public  double getMonthlyInterestRate () {
        return (this.annualInterestRate / 12) ;
    }

    public double getMonthlyInterest () {
        return (this.balance * getAnnualInterestRate()) ;
    }

    // Do the real method
    public void withdraw ( double money) {
        if (this.balance >= money) {
            this.balance = this.balance - money ;
        } else
            System.out.println("Do not have enough money to withdraw");

//        Transaction t = new Transaction ('W' , money ,this.balance ,"Withdraw from account. ") ;
//        transactions.add(t) ; // This add(t) is add a data type of the arraylist which is Transaction ,
        // that explains why we can add t in this function .
    }

    public  void deposit ( double money ) {
        this.balance = this.balance + money ;
//        Transaction t = new Transaction('D',money,this.balance,"Deposit to the account");
//        transactions.add(t) ;
    }
}

class Checking extends Account {


    public Checking(int id, double balance, String name) {
        super(id,balance, name);
    }

    @Override
    public void withdraw (double money) {
        super.withdraw(money);
        System.out.println("Withdraw successfully") ;
    }


}

class Saving extends Account {

    public Saving(int id, double balance , String name) {
        super(id,balance,name);
    }

    @Override
    public void withdraw(double money) {
        super.withdraw(money);
        if (super.getBalance() < 0) {
            System.out.println("Cannot withdraw the money which is more than in the bank account.") ;
            super.deposit(money);
        }
    }


}

class Transaction {
    private Date date ;
    private char type ;
    private double amount ;
    private double balance ;
    private String description ;

    Transaction (char type , double amount , double balance , String description) {
        this.type = type ;
        this.amount = amount ;
        this.balance = balance ;
        this.description = description ;
        this.date  = new Date();
    }

    public char getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(char type) {
        this.type = type;
    }

}

// ** NOTE : transactions.add(t) This add(t) is add a data type of the arraylist which is Transaction ,
//                               that explains why we can add t in this function .
// get (index) method  : Index is the location of the arraylist , which starts from 0 to the size - 1 of the array list.


// private ArrayList <Transaction> transactions ;
//
//    public ArrayList<Transaction> getTransactions() {
//        return transactions;
//    } => this to call out the function in the arraylist to do its job.
// myAccount.getTransactions()).get(i).getBalance()); ( THE FUNCTION IS CALLED ) .
//
