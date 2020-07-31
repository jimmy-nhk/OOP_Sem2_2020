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

import java.util.Scanner;

public abstract class Item {
    // Data fields of Collection class
    private String title;
    private String publication;
    private int year;
    private String language;
    private String status;
    private int numberOfCopies;

    // Constructors of Collection class
    public Item(){}

    public Item(String title , String publication, String year , String language,String status,String numberOfCopies) {
        this.title = title;
        this.publication = publication;
        this.language = language;

        //Check the right form of the year
        Scanner scanner = new Scanner(System.in);
        if (verifyInt(year)){
            this.year = Integer.parseInt(year);
        } else {
            System.out.println("Enter again the year in the correct format: ");
            try {
                this.year = scanner.nextInt();
                scanner.nextLine(); // This helps for the next scan
            } catch (Exception e){
                this.year = 0;
            }
        }

        // Check the right form for the status
        boolean check = true;
        while (check) {
            if (status.toUpperCase().equals("ON LOAN")){
                this.status = "On Loan";
                check = false;
            } else if (status.toUpperCase().equals("AVAILABLE")){
                this.status = "Available";
                check = false;
            } else {
                System.out.println("Enter again the status in the correct format ( Available or On Loan ): ");
                status = scanner.nextLine();
            }
        }


        // Check the right format of numberOfCopies
        if (verifyInt(numberOfCopies)){
            this.numberOfCopies = Integer.parseInt(numberOfCopies);
        } else {
            System.out.println("Enter again the number of copies in the correct format: ");
            try {
                this.numberOfCopies = scanner.nextInt();
                scanner.nextLine(); // This helps for the next scan
            } catch (Exception e){
                this.numberOfCopies = 1;
            }
        }

    }

    public abstract String toString();

    // Method to verify the string in the correct format.
    static boolean verifyInt(String integer) {
        try{
            int a = Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
