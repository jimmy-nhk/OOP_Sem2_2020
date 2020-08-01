/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2020B
  Assessment: Assignment 1
  Author: Nguyen Hoang Khang
  ID: s3802040
  Created  date: 29/07/2020
  Last modified:
  Acknowledgement: Acknowledge the resources that you use here.
*/

package LibraryManagment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    // Properties of Member class
    private String fullName;
    private String id;
    private String phone;
    private String mail;
    private String address;
    private LocalDate expiredDate ;
    private String status;
    private double lateFee;
    private ArrayList<Loan> loans;

    //Constructors of Member class
    public Member(){}
    public Member(String fullName,String id,String phone,String mail,String address,String date, String status){
        this.fullName = fullName;
        this.id = id;
        this.mail = mail;
        this.address = address;
        lateFee = 0 ;
        setPhone(phone); // Check the validation format
        setStatus(status); // Check the validation format
        setExpiredDate(date);
    }

    // Methods:
    // Set methods (mutators):

    public void addLoans (Loan loan) {
        if (loans.size() <= 5){
            loans.add(loan);
            System.out.println("Successfully added");
        } else
            System.out.println("One member can only have 5 loans at the same time");
    }

    public String getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        Scanner scanner = new Scanner(System.in);
        // Check the format of phone
        if (Item.verifyInt(phone)){
            this.phone = phone;
        } else {
            do {
                System.out.println("Enter phone number in the correct format");
                this.phone = scanner.nextLine();
            } while (!Item.verifyInt(this.phone));
        }
    }

    public void setMail(String mail) {
        String pattern = ".*@rmit\\.edu\\.vn";
        if (mail.matches(pattern)){
            this.mail = mail;
        } else{
            System.out.println("The input format is incorrect. The data will not be saved");
            this.mail = "";
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setExpiredDate(String date) {
        try {
            this.expiredDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e){
            System.out.println("Failure to input the expired date. Please follow the instructed format\nThe expired date has not yet been updated");
        }
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public void addLateFee (){
        double lateFee = 0 ;
        for (int i = 0 ; i < loans.size(); i++){
            lateFee += loans.get(i).calculateFee();
        }
        this.lateFee += lateFee;
    }

    public void setStatus(String status) {
        Scanner scanner = new Scanner(System.in);
        // Check the format of status in the right form
        if (status.equalsIgnoreCase("active") || status.equalsIgnoreCase("expired")) {
            this.status = status;
        } else {
            do {
                System.out.println("Enter the status ( active or expired): ");
                this.status = scanner.nextLine();
            } while (!(this.status.equalsIgnoreCase("active")) && !(this.status.equalsIgnoreCase("expired")));

        }
    }
    // This method to display the information to the console
    public String getString(){
        return fullName + "\n" + id + "\n" + phone +
                "\n" + mail + "\n" + address + "\n"
                + expiredDate.toString() + "\n" + status +
                "\nLate Fee: " + lateFee + "\n";
    }
    @Override
    public String toString() {

        return fullName + id + phone + mail + address + expiredDate.toString() + status + lateFee;

    }
}
