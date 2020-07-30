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

public class Book extends Item{
    // Data fields of Book class
    private String author;
    private String edition;
    private String isbn;

    //Constructors of Book class
    public Book(){}

    @Override
    public String toString() {
        return null;
    }

    public Book(String title , String author, String edition , String publication, String year, String language,String status,String copy ,  String isbn){
        super(title ,  publication,  year ,  language, status, copy);
        this.author = author;
        this.edition = edition;

        // Check the constraints of ISBN:
        if (verifyISBN(isbn)){
            this.isbn = isbn;
        } else {
            System.out.println("Enter again the isbn in the correct format: ");
            try {
                Scanner scanner = new Scanner(System.in);
                this.isbn = scanner.next();
            } catch (Exception e){
                this.isbn = "";
            }
        }
    }

    // The method to check the validation of ISBN
    static boolean verifyISBN(String isbn){
        if (( verifyInt(isbn) && isbn.length() == 10 ) || (verifyInt(isbn) && isbn.length() == 13 ))
            return true;
        else
            return false;
    }

}
