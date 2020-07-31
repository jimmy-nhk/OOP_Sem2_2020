package LibraryManagment;

import java.util.ArrayList;
import java.util.Scanner;

import static LibraryManagment.Book.verifyISBN;
import static LibraryManagment.Item.verifyInt;
import static LibraryManagment.Journal.verifyISSN;

public class ItemList {
    // Data fields:
    private ArrayList<Item> itemList = new ArrayList<>();

    //Methods:
    public void searchItem (){
    }

    public void addNewItem(){
        System.out.println("What is the item ?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        switch (input){
            case "BOOK":
                newBook();
                break;
            case "DVD":
                newDVD();
                break;
            case "JOURNAL":
                newJournal();
                break;
            default:
                System.out.println("Nothing has been inputted yet or in the wrong type. Please select the method again if you want further action");
        }
    }

    // Method in the main menu
    public void updateItemInfo (){
        System.out.println("What is the item ?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        switch (input){
            case "BOOK":
                bookUpdate();
                break;
            case "DVD":
                dvdUpdate();
                break;
            case "JOURNAL":
                journalUpdate();
                break;
            default:
                System.out.println("Cannot find the input item");
        }
    }

    // Methods contribute for updateItemInfo method
    public void journalUpdate (){
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        System.out.println("What is the ISSN of this journal?");
        String issn = scanner.nextLine();
        for (int i = 0 ; i < itemList.size(); i++){
            if (itemList.get(i) instanceof Journal){
                if (issn.equalsIgnoreCase(((Journal) itemList.get(i)).getIssn())){
                    while (check){
                        System.out.println("Which information wanted to be updated ?\n(Title / Author / Publication / Year / ISBN / numberOfCopies\n Enter 0 to finish updating )");
                        String information = scanner.nextLine().toUpperCase();
                        switch (information){
                            case "TITLE":
                                System.out.println("What is the new title ? ");
                                itemList.get(i).setTitle(scanner.nextLine());
                                break;
                            case "PUBLICATION":
                                System.out.println("Who are the publications ? ");
                                itemList.get(i).setPublication(scanner.nextLine());
                                break;
                            case "YEAR":
                                System.out.println("What is the year ?");
                                itemList.get(i).setYear(scanner.nextInt());
                                scanner.nextLine(); // This helps later scanner
                                break;
                            case "LANGUAGE":
                                System.out.println("What is the language of the journal?");
                                itemList.get(i).setLanguage(scanner.nextLine());
                            case "STATUS":
                                System.out.println("Is it on loan or available ?");
                                itemList.get(i).setStatus(scanner.nextLine());
                                break;
                            case "NUMBER OF COPIES":
                                System.out.println("What is the number of copies?");
                                itemList.get(i).setNumberOfCopies(scanner.nextInt());
                                scanner.nextLine();
                                break;
                            case "0":
                                check = false;
                                scanner.nextLine();
                                break;
                            default:
                                System.out.println("No data field like that in this Journal");
                        }
                    }
                }
            }
        }
    }

    // Methods contribute for updateItemInfo method
    public void dvdUpdate(){
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        try {
            System.out.println("What is the id of this DVD?");
            int id = Integer.parseInt(scanner.nextLine());
            for (int i = 0 ; i < itemList.size(); i++){
                if (itemList.get(i) instanceof DVD){
                    if (id == ((DVD) itemList.get(i)).getId() ){
                        while (check){

                            // Ask what information to be updated
                            System.out.println("Which information wanted to be updated ?\n(Title / Author / Publication / Year / ISBN / numberOfCopies etc.. \n Enter 0 to finish updating )");
                            String information = scanner.nextLine().toUpperCase();
                            switch (information){
                                case "TITLE":
                                    System.out.println("What is the new title ? ");
                                    itemList.get(i).setTitle(scanner.nextLine());
                                    break;
                                case "PUBLICATION":
                                    System.out.println("Who are the publications ? ");
                                    itemList.get(i).setPublication(scanner.nextLine());
                                    break;
                                case "AUTHOR":
                                    System.out.println("Who are the authors? ");
                                    ((DVD) itemList.get(i)).setAuthor(scanner.nextLine());
                                    break;
                                case "YEAR":
                                    System.out.println("What is the year ?");
                                    itemList.get(i).setYear(scanner.nextInt());
                                    scanner.nextLine(); // This helps later scanner
                                    break;
                                case "LANGUAGE":
                                    System.out.println("What is the language of the book?");
                                    itemList.get(i).setLanguage(scanner.nextLine());
                                case "STATUS":
                                    System.out.println("Is it on loan or available ?");
                                    itemList.get(i).setStatus(scanner.nextLine());
                                    break;
                                case "NUMBER OF COPIES":
                                    System.out.println("What is the number of copies?");
                                    itemList.get(i).setNumberOfCopies(scanner.nextInt());
                                    scanner.nextLine();
                                    break;
                                case "0":
                                    check = false;
                                    scanner.nextLine();
                                    break;
                                default:
                                    System.out.println("No data field like that in this DVD");
                            }
                        }
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Cannot find the DVD you typed");
        }
    }

    // Methods contribute for updateItemInfo method
    public void bookUpdate (){
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        System.out.println("What is the ISBN of this book?");
        String isbn = scanner.nextLine();
        for (int i = 0 ; i < itemList.size(); i++){
            if (itemList.get(i) instanceof Book){
                if (isbn.equalsIgnoreCase(((Book) itemList.get(i)).getIsbn())){
                    while (check){
                        System.out.println("Which information wanted to be updated ?\n(Title / Author / Publication / Year / ISBN / numberOfCopies\n Enter 0 to finish updating )");
                        String information = scanner.nextLine().toUpperCase();
                        switch (information){
                            case "TITLE":
                                System.out.println("What is the new title ? ");
                                itemList.get(i).setTitle(scanner.nextLine());
                                break;
                            case "PUBLICATION":
                                System.out.println("Who are the publications ? ");
                                itemList.get(i).setPublication(scanner.nextLine());
                                break;
                            case "AUTHOR":
                                System.out.println("Who are the authors? ");
                                ((Book) itemList.get(i)).setAuthor(scanner.nextLine());
                                break;
                            case "EDITION":
                                System.out.println("What is the edition ?");
                                ((Book) itemList.get(i)).setEdition(scanner.nextLine());
                                break;
                            case "YEAR":
                                System.out.println("What is the year ?");
                                itemList.get(i).setYear(scanner.nextInt());
                                scanner.nextLine(); // This helps later scanner
                                break;
                            case "LANGUAGE":
                                System.out.println("What is the language of the book?");
                                itemList.get(i).setLanguage(scanner.nextLine());
                            case "STATUS":
                                System.out.println("Is it on loan or available ?");
                                itemList.get(i).setStatus(scanner.nextLine());
                                break;
                            case "NUMBER OF COPIES":
                                System.out.println("What is the number of copies?");
                                itemList.get(i).setNumberOfCopies(scanner.nextInt());
                                scanner.nextLine();
                                break;
                            case "0":
                                check = false;
                                scanner.nextLine();
                                break;
                            default:
                                System.out.println("No data field like that in this Book");
                        }
                    }
                }
            }
        }
    }

    public void displayItem(){}

    // Methods import items:
    public void newJournal(){
        Scanner scanner = new Scanner(System.in);
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

        // Check if the ISSN is unique and in the correct format
        while (true){
            do {
                if (verifyISSN(issn)){
                    break;
                } else {
                    // Re-enter the issn until it is in the right format
                    System.out.println("Enter again the ISSN in the correct format: ");
                    issn = scanner.nextLine().trim();
                    if (verifyISSN(issn))
                        break;
                }
            } while (true);
            if (!checkISSNUnique(issn)){
                // Re-enter the ISBN until it is unique
                System.out.println("The ISSN already exists. Please re-enter the ISSN:");
                issn = scanner.nextLine().trim();
            } else
                break;
        }

        itemList.add(new Journal(title2,publication2,year2,language2,status2,numberOfCopies2, issn));
        // Announce the done action:
        System.out.println("Successfully added");
        scanner.nextLine(); // Give the user time to see user's input
    }
    public void newDVD(){
        Scanner scanner = new Scanner(System.in);
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

        // Announce the done action:
        System.out.println("Successfully added");
        scanner.nextLine(); // Give the user time to see user's input
    }

    public void newBook (){
        Scanner scanner = new Scanner(System.in);
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

        // Check if isbn is unique and in the correct format
        while (true){
            do {
                if (verifyISBN(isbn)){
                    break;
                } else {
                    // Re-enter the ISBN until it is in the right format
                    System.out.println("Enter again the isbn in the correct format: ");
                    isbn = scanner.nextLine().trim();
                    if (verifyISBN(isbn))
                        break;
                }
            } while (true);
            if (!checkISBNUnique(isbn)){
                // Re-enter the ISBN until it is unique
                System.out.println("The ISBN already exists. Please re-enter the ISBN:");
                isbn = scanner.nextLine().trim();
            } else
                break;
        }

        // Add the book to the itemList ArrayList
        itemList.add(new Book(title,author,edition,publication,year,language,status,numberOfCopies,isbn));

        // Announce the done action:
        System.out.println("Successfully added");
        scanner.nextLine(); // Give the user time to see user's input

    }

    // Check if the book already exists
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

    // Check if the journal already exists
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
}
