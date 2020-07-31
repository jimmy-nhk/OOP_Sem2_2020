package LibraryManagment;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemList {
    // Data fields:
    private ArrayList<Item> itemList = new ArrayList<>();

    //Methods:
    public void searchItem (){
    }

    public void addNewItem(){
        System.out.println("What type of Item is ?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        switch (input){
            case "BOOK":
                // Enter the information of the book
                System.out.println("What is the title of the book? ");
                String title = scanner.nextLine().trim();
                System.out.println("What is the author of the book?");
                String author = scanner.nextLine().trim();
                System.out.println("What is the edition? ");
                String edition = scanner.nextLine().trim();
                System.out.println("What is the publication? ");
                String publication = scanner.nextLine().trim();
                System.out.println("What is the year? ");
                String year = scanner.nextLine().trim();
                System.out.println("What is the language of this book? ");
                String language = scanner.nextLine().trim();
                System.out.println("Is it available or on loan ?");
                String status = scanner.nextLine().trim();
                System.out.println("How many copies of this book?");
                String numberOfCopies = scanner.nextLine().trim();
                System.out.println("What is its ISBN ?");
                String isbn = scanner.nextLine().trim();

                // Check if isbn is unique
                while (true){
                    if (!checkISBNUnique(isbn)){
                        System.out.println("The ISBN already exists. Please re-enter the ISBN:");
                        isbn = scanner.nextLine().trim();
                    } else
                        break;
                }

                // Add the book to the itemList ArrayList
                itemList.add(new Book(title,author,edition,publication,year,language,status,numberOfCopies,isbn));
                break;

            case "DVD":
                // Enter the information of the DVD
                System.out.println("What is the title of the DVD? ");
                String title1 = scanner.nextLine().trim();
                System.out.println("What is the author of the DVD?");
                String author1 = scanner.nextLine().trim();
                System.out.println("What is the publication? ");
                String publication1 = scanner.nextLine().trim();
                System.out.println("What is the year? ");
                String year1 = scanner.nextLine().trim();
                System.out.println("What is the language of this DVD? ");
                String language1 = scanner.nextLine().trim();
                System.out.println("Is it available or on loan ?");
                String status1 = scanner.nextLine().trim();
                System.out.println("How many copies of this DVD?");
                String numberOfCopies1 = scanner.nextLine().trim();
                itemList.add(new DVD(title1,author1,publication1,year1,language1,status1,numberOfCopies1));
                break;

            case "JOURNAL":
                // Enter the information of the Journal
                System.out.println("What is the title of the Journal? ");
                String title2 = scanner.nextLine().trim();
                System.out.println("What is the publication? ");
                String publication2 = scanner.nextLine().trim();
                System.out.println("What is the year? ");
                String year2 = scanner.nextLine().trim();
                System.out.println("What is the language of this Journal? ");
                String language2 = scanner.nextLine().trim();
                System.out.println("Is it available or on loan ?");
                String status2 = scanner.nextLine().trim();
                System.out.println("How many copies of this Journal?");
                String numberOfCopies2 = scanner.nextLine().trim();
                System.out.println("What is the ISSN of this Journal?");
                String issn = scanner.nextLine().trim();
                itemList.add(new Journal(title2,publication2,year2,language2,status2,numberOfCopies2, issn));
                break;
            default:
                System.out.println("Nothing has been inputted yet or in the wrong type. Please select the method again if you want further action");
        }
    }

    public boolean checkISBNUnique (String isbn){
        for (int i = 0 ; i < itemList.size(); i++){
            if (itemList.get(i) instanceof Book){
                if (isbn.equalsIgnoreCase(((Book) itemList.get(i)).getIsbn())){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkISSNUnique (String isbn){
        for (int i = 0 ; i < itemList.size(); i++){
            if (itemList.get(i) instanceof Journal){
                if (isbn.equalsIgnoreCase(((Journal) itemList.get(i)).getIssn())){
                    return false;
                }
            }
        }
        return true;
    }

    public void updateItemInfo (){}

    public void displayItem(){}
}
