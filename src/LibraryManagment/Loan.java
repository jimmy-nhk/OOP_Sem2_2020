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
import java.util.Objects;
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
        returnedDate = null; // Temporarily set returned Date to now
    }

    // Methods:

    public Item getItem() {
        return item;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setReturnedDate( String date) {
        try {
            this.returnedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e){
            System.out.println("Failure to set returned date because the input format is incorrect");
        }

    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    /** This Method calculates the Fee */
    public double calculateFee(){
        double lateFee = 0 ;
        final double FEECHARGED = 0.1;
        try {
            long daysBetween = ChronoUnit.DAYS.between(issuedDate,returnedDate);
            if (item instanceof Book){ // if it is a book , must return before 15 days
                lateFee = daysBetween <= 14 ? FEECHARGED * 0 : FEECHARGED * (daysBetween - 14);
            } else if (item instanceof DVD || item instanceof Journal){ // if it is either a DVD or a Journal, must return before 8 days
                lateFee = daysBetween <= 7 ? FEECHARGED * 0 : FEECHARGED * (daysBetween - 7);
            }
        } catch (Exception e){
            System.out.println("The member has not returned the item yet");
        }

        return lateFee;
    }

    @Override
    public String toString() {
        return "Loan {" +
                "issuedDate = " + issuedDate +
                ", returnedDate = " + returnedDate +
                ", item = " + item.getTitle() +"}\n" ;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return Objects.equals(issuedDate, loan.issuedDate) &&
                Objects.equals(item, loan.item) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuedDate, returnedDate, item, scanner);
    }
}
