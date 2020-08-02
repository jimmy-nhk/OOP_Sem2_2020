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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    // Attributes:
    public static ItemList itemList = new ItemList();
    public static MemberList memberList = new MemberList();
    public static Scanner scanner = new Scanner(System.in);




    // Methods:

    public static void main(String[] args) {
        // Start the program by loading all the files in:
        start();

        while (true){
            // Display the menu first for the user
            displayMenu();

            // If it is in the wrong format, please kindly re-enter the input
            try {
                int input = Integer.parseInt(scanner.nextLine());
                while (input < 1 || input > 10 ){
                    System.out.println("The input should be the integer from 1 to 10.\nPlease kindly re-input the function:");
                    input = Integer.parseInt(scanner.nextLine());
                }

                // Choose the function:
                switch (input){
                    case 1:
                        itemList.searchItem();
                        break;
                    case 2:
                        itemList.addNewItem();
                        break;
                    case 3:
                        itemList.updateItemInfo();
                        break;
                    case 4:
                        memberList.searchMember();
                        break;
                    case 5:
                        memberList.addNewMember();
                        break;
                    case 6:
                        memberList.updateMemberInfo();
                        break;
                    case 7:
                        borrowItems();
                        break;
                    case 8:
                        returnItems();
                        break;
                    case 9:
                        saveData();
                        break;
                    case 10:
                        System.out.println("The program exits. Bye!");
                        quit();
                }
            } catch (Exception e)
            {
                System.out.println("The input should be an integer from 1 to 10.");
            }
        }
    }
    public static void start(){
        itemList.start();
        memberList.start();
    }

    // Display the menu:
    public static void displayMenu(){
        System.out.println("Welcome to QuickLib!!!\n" +
                "********************************\n" +
                "1. Search items by keywords\n" +
                "2. Add new item\n" +
                "3. Update item info\n" +
                "4. Search members by keywords\n" +
                "5. Register new member\n" +
                "6. Update member info\n" +
                "7. Borrow items\n" +
                "8. Return items\n" +
                "9. Save data\n" +
                "10. Quit\n" +
                "**************************************\n" +
                "Enter a function (1-10):");
    }

    public static void saveData(){
    }

    public static void quit(){
        System.exit(0);
    }

    public static void borrowItems (){
        System.out.println("Enter the ISBN (Book) or ID (DVD) or ISSN (Journal): ");
        String input = scanner.nextLine();

        // Check if the item exists in the library:
        if (checkItemExists(input)){
            // Add the item to the method
            int itemTh = returnItemExists(input); /** which is the item in the itemList */

            // Check the item status , if it is not available, display a message
            if (checkItemStatus(itemList.getItems().get(itemTh))){

                // Check the id of the member:
                System.out.println("Enter the id of the member: ");
                String id = scanner.nextLine();

                // Check if the member exists
                if (checkMemberExists(id)){

                        /** Which is the member in the memberList: */
                        int memberTh = returnMemberExists(id);

                         /** Add the loan to the member */
                         memberList.getMembers().get(memberTh).addLoans(new Loan(itemList.getItems().get(itemTh)));
                } else {
                    System.out.println("The member does not exists in the system.");
                }
            } else {
                System.out.println("This item is not available yet.");
            }

        } else {
            System.out.println("The item cannot be found in the system.");
        }
        scanner.nextLine();
    }



    // Check the status of the item to make sure it is available:
    public static boolean checkItemStatus(Item item){
        if (item.getStatus().equalsIgnoreCase("available")){
            return true;
        } else
            return false;
    }

    // Return the actual item:
    public static int returnItemExists ( String input) {

        for (int i = 0; i < itemList.getItems().size(); i++) {
            // Double access to get the member id to compare with the entered keyword
            if (itemList.getItems().get(i) instanceof Book) {
                if (((Book) itemList.getItems().get(i)).getIsbn().equalsIgnoreCase(input)) {
                    return i;
                }
                // Check through out the 3 cases:
            } else if (itemList.getItems().get(i) instanceof DVD) {
                // Just in case the input is not the integer so it is needed to handle the error
                try {
                    if (((DVD) itemList.getItems().get(i)).getId() == Integer.parseInt(input)) {
                        return i;
                    }
                } catch (Exception e) {
                }
            } else if (itemList.getItems().get(i) instanceof Journal) {
                if (((Journal) itemList.getItems().get(i)).getIssn().equalsIgnoreCase(input)) {
                    return i;
                }
            }
        }
        return 0;
    }

//     Check if the item exists
    public static boolean checkItemExists ( String input) {

        // Run the loop to check if the item exists
        for (int i = 0; i < itemList.getItems().size(); i++) {
            // Double access to get the member id to compare with the entered keyword
            if (itemList.getItems().get(i) instanceof Book) {
                if (((Book) itemList.getItems().get(i)).getIsbn().equalsIgnoreCase(input)) {
                    return true;
                }
            } else if (itemList.getItems().get(i) instanceof DVD) {
                try {
                    if (((DVD) itemList.getItems().get(i)).getId() == Integer.parseInt(input)) {
                        return true;
                    }
                } catch (Exception e) {
                }
            } else if (itemList.getItems().get(i) instanceof Journal) {
                if (((Journal) itemList.getItems().get(i)).getIssn().equalsIgnoreCase(input)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check if the member is already registered in the library
    public static boolean checkMemberExists( String id){
        for (int i = 0 ; i < memberList.getMembers().size(); i++){
            // Double access to get the member id to compare with the entered keyword
            if (memberList.getMembers().get(i).getId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }

    // Return which member in the memberList wants to borrow an item:
    public static int returnMemberExists (String id){
        for (int i = 0 ; i < memberList.getMembers().size(); i++){
            // Double access to get the member id to compare with the entered keyword
            if (memberList.getMembers().get(i).getId().equalsIgnoreCase(id)){
                return i;
                }
        }
        return 0;
    }



    public static void returnItems (){
        System.out.println("Enter the ID member: ");
        String id = scanner.nextLine();

        // Check if member exists
        if (checkMemberExists(id)){

            int memberTh = returnMemberExists(id);
            System.out.println("Enter the ISBN (Book) or ID (DVD) or ISSN (Journal): ");
            String input = scanner.nextLine();

            // Check if item exists
            if (checkItemExists(input)){
                int itemTh = returnItemExists(input);

                // Check the loan of this member
                int loanTh = memberList.getMembers().get(memberTh).findLoan(itemList.getItems().get(itemTh));
                // This variable shows which loan the member wants to return
                if ( loanTh >= 0){

                    // Enter the return date:
                    System.out.println("Enter the returned date:\neg: 05-11-2020");

                    // Complete the loan class:
                    memberList.getMembers().get(memberTh).getLoans()[loanTh].setReturnedDate(scanner.nextLine().trim());

                    // Calculate the late fee
                    double fee = memberList.getMembers().get(memberTh).getLoans()[loanTh].calculateFee();
                    memberList.getMembers().get(memberTh).setLateFee(fee);

                    System.out.println(memberList.getMembers().get(memberTh).getLateFee());
                    // Update the number of copies on loan
                    itemList.getItems().get(itemTh).decreaseNumberOfCopiesOnLoan();

                    // Update status of the item:
                    itemList.getItems().get(itemTh).setStatus("Available");

                    memberList.getMembers().get(memberTh).getLoans()[loanTh] = null; // Remove the loan from the memberList

                    System.out.println("Successfully return the item");
                } else {
                    System.out.println("This member has not borrowed this item before.");
                }
            }
        } else {
            System.out.println("This member does not exists. Please re-select the method");
        }
    }

    public void displayBorrowedItem (){}
}
