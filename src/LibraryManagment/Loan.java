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
    private Member member;

    //Constructors of Loan class
    public Loan(){}
    public Loan(Item item, Member member){
        issuedDate = Calendar.getInstance(); // This method returns the current date
        this.item = item;
        this.member = member;
        this.returnedDate.set(0,0,0);
    }

    // Methods:

    public void setReturnedDate() {
        Scanner scanner = new Scanner(System.in);

        // Enter the returned date
        System.out.println("Enter the year: ");
        int year = scanner.nextInt();
        System.out.println("Enter the month: ");
        int month = scanner.nextInt();
        System.out.println("Enter the date: ");
        int date = scanner.nextInt();

        this.returnedDate.set(year,month,date);
    }

    public double calculateFee(){
        // This is where it is a reference from StackOverFlow
        long daysBetween = ChronoUnit.DAYS.between(returnedDate.toInstant(), issuedDate.toInstant());

        return (double) daysBetween;
    }
}
