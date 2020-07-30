package LibraryManagment;

import java.util.Scanner;

public abstract class Item {
    // Data fields of Collection class
    private String title;
    private String publication;
    private int year;
    private String language;
    private boolean status; // If available, the status is true and if it is not, it will be false
    private int numberOfCopies;

    // Constructors of Collection class
    public Item(){}
    public Item(String title , String publication, String year , String language,boolean status,int numberOfCopies) {
        this.title = title;
        this.publication = publication;

        //Check the right form of the year
        if (verifyInt(year)){
            this.year = Integer.parseInt(year);
        } else {
            System.out.println("Enter again the year in the correct format: ");
            try {
                Scanner scanner = new Scanner(System.in);
                this.year = scanner.nextInt();
            } catch (Exception e){
                this.year = 0;
            }
        }

        this.language = language;
        this.status = status;
        this.numberOfCopies = numberOfCopies;

    }

    // Method to verify the string in the correct format.
    static boolean verifyInt(String integer) {
        try{
            int a = Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
