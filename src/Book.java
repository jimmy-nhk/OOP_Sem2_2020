package LibraryManagment;

import java.util.Scanner;

public class Book extends Item{
    // Data fields of Book class
    private String author;
    private int edition;
    private String isbn;

    //Constructors of Book class
    public Book(){}
    public Book(String title , String publication, String year , String language,boolean status,int copy, String author , int edition, String isbn){
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
