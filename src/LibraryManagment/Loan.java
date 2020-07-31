/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2020B
  Assessment: Assignment 1
  Author: Nguyen Hoang Khang
  ID: s3802040
  Created  date: 29/07/2020
  Last modified:
  Acknowledgement:
  https://stackoverflow.com/questions/19462912/how-to-get-number-of-days-between-two-calendar-instance
*/

package LibraryManagment;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Scanner;

public class Loan {
    // Properties of Loan class
    private Calendar issuedDate;
    private Calendar returnedDate;
    private Item item;
    Scanner scanner = new Scanner(System.in);

    //Constructors of Loan class
    public Loan(){}
    public Loan(Item item){
        issuedDate = Calendar.getInstance(); // This method returns the current date
        this.item = item;
        this.returnedDate.set(0,1,0);
    }

    // Methods:

    public void setDate(Calendar date) {

        // Enter the returned date
        System.out.println("Enter the year: ");
        int year = scanner.nextInt();
        System.out.println("Enter the month: ");
        int month = scanner.nextInt();
        System.out.println("Enter the date: ");
        int day = scanner.nextInt();

        date.set(year,month,day);
    }

    public void setReturnedDate() {
        setDate(returnedDate);
    }

    public void setIssuedDate() {
        setDate(issuedDate);
    }

    /** This Method has not done yet */
    public void calculateFee(){
    }

    public boolean checkIfOnTime (){
        // This is where it is a reference from StackOverFlow
        long daysBetween = ChronoUnit.DAYS.between(returnedDate.toInstant(), issuedDate.toInstant());
        return daysBetween <= 14  ;
    }
}
