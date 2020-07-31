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
//        do {
//            if (verifyISBN(isbn)){
//                this.isbn = isbn;
//                break;
//            } else {
//                // Re-enter the ISBN until it is in the right format
//                System.out.println("Enter again the isbn in the correct format: ");
//                Scanner scanner = new Scanner(System.in);
//                this.isbn = scanner.nextLine().trim();
//                if (verifyISBN(this.isbn))
//                    break;
//            }
//        } while (true);
        this.isbn = isbn;

    }


    // The method to check the validation of ISBN
    public static boolean verifyISBN(String isbn){
        return verifyInt(isbn) && isbn.length() == 10;
    }

    // Methods:


    public String getIsbn() {
        return isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setIsbn(String isbn) {
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
}
