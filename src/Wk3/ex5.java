package Wk3;

public class ex5 {

    public static void main ( String [] args) {
        Account myAccount = new Account(1212,20000 ,"Jimmy") ;

        myAccount.setId(1212);
        myAccount.setBalance(20000);
        myAccount.setAnnual(4.5);
        myAccount.withdraw(2000);
        myAccount.deposit(1000);

        System.out.println("Balance: $" + myAccount.getBalance());
        System.out.println("Monthly Interest: " + myAccount.getMonthlyInterest());
        System.out.println("Date Created: " + myAccount.getDate());
        System.out.println(myAccount.getId());

        Checking a = new Checking(12,5000 , "Khang") ;
        Saving b = new Saving(13,600 , " Hello") ;

        a.withdraw(6000);
        b.withdraw(600);

        System.out.println (a.toString() );

//        for (int i = 0; i < myAccount.getTransactions().size(); i++) {
//            System.out.println("Date: " +
//                    (myAccount.getTransactions()).get(i).getDate());
//            System.out.println("Type: " +
//                    (myAccount.getTransactions()).get(i).getType());
//            System.out.println("Amount: " +
//                    (myAccount.getTransactions()).get(i).getAmount());
//            System.out.println("Balance: " +
//                    (myAccount.getTransactions()).get(i).getBalance());
//            System.out.println("Description: " +
//                    (myAccount.getTransactions()).get(i).toString());
//            System.out.println();
//        }
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