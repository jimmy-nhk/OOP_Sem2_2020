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
*/

package LibraryManagment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Loan {
    // Properties of Loan class
    private LocalDate issuedDate;
    private LocalDate returnedDate;
    private Item item;
    Scanner scanner = new Scanner(System.in);

    //Constructors of Loan class
    public Loan(){}
    public Loan(Item item){
        issuedDate = LocalDate.now(); // This method returns the current date
        this.item = item;
        returnedDate = LocalDate.now(); // Temporarily set returned Date to now
    }

    // Methods:


    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setReturnedDate() {
        try {
            System.out.println("Enter the returned date following the format dd-MM-yyyy: ");
            String date = scanner.nextLine();
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            this.returnedDate = localDate;
        } catch (Exception e){
            System.out.println("Failure to set returned date because the input format is incorrect");
        }

    }

    /** This Method calculates the Fee */
    public double calculateFee(){
        double lateFee = 0 ;
        final double FEECHARGED = 0.1;
        long daysBetween = ChronoUnit.DAYS.between(returnedDate,issuedDate);
        if (item instanceof Book){ // if it is a book , must return before 15 days
            lateFee = daysBetween <= 14 ? FEECHARGED * 0 : FEECHARGED * (daysBetween - 14);
        } else if (item instanceof DVD || item instanceof Journal){ // if it is either a DVD or a Journal, must return before 8 days
            lateFee = daysBetween <= 7 ? FEECHARGED * 0 : FEECHARGED * (daysBetween - 7);
        }
        return lateFee;
    }


}
