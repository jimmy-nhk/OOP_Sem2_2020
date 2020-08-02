package LibraryManagment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static LibraryManagment.Menu.*;

public class Test {
    public static ItemList itemList = new ItemList();
    public static MemberList memberList = new MemberList();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

         itemList.start();
         memberList.start();
        System.out.println(itemList.getItems().get(0).toString());
        Scanner scanner = new Scanner(System.in);
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
                    int memberTh = 0 ;

                        /** Which is the member in the memberList: */
                        memberTh = returnMemberExists(id);
                        System.out.println(memberTh);

                /** Above to this point is right / Please recheck again the below statement */
                    memberList.getMembers().get(memberTh).addLoans(new Loan(itemList.getItems().get(itemTh)));
                    // member.addLoans(new Loan(itemList.getItems().get(itemTh)));
                    // memberList.getMembers().set(memberTh,member);
//                    finally {
//                        // Check the capability of the member having enough items yet ?
//                        if (memberList.getMembers().get(memberTh).getLoans().size() < 5){
//
//                            // Add the loan to the member information
//                            memberList.getMembers().get(memberTh).getLoans().add(new Loan(itemList.getItems().get(itemTh)));
//
//                            // Increase the number of copy on loan:
//                            itemList.getItems().get(itemTh).increaseNumberOfCopiesOnLoan();
//
//                            // Check the number of copies and number on loan.
//                            if (itemList.getItems().get(itemTh).getNumberOfCopiesOnLoan() < itemList.getItems().get(itemTh).getNumberOfCopies() ){
//
//                                // If the number of copies on loan is less than number of copy, status is set to Available. Otherwise, it is On loan.
//                                itemList.getItems().get(itemTh).setStatus("Available");
//                            } else {
//                                itemList.getItems().get(itemTh).setStatus("On loan");
//                            }
//                            // Announce the successful statement:
//                            System.out.println("Successfully borrow the item.");
//
//                        } else {
//                            System.out.println("This member cannot borrow more than 5 items at the same time.");
//                        }
//                    }



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



















//        Scanner scanner = new Scanner(System.in);
//        ArrayList<Member> memberList = new ArrayList<>();
//        final File MEMBERFILE = new File("src/Member.txt");
////        System.out.println("Enter the keyword you want to search: ");
////        String input = scanner.nextLine();
////        String pattern = ".*"+input+".*";
////        String hello = "hellocac\nban";
////        System.out.println(hello.matches(pattern));
//
//        try{
//            Scanner sc = new Scanner(MEMBERFILE);
//            while (sc.hasNext()) {
//                String name = sc.nextLine();
//                String id = sc.nextLine();
//                String phone = sc.nextLine();
//                String mail = sc.nextLine();
//                String address = sc.nextLine();
//                String date = sc.nextLine();
//                String status = sc.nextLine();
//                memberList.add(new Member(name, id, phone, mail, address, date, status));
//            }
//            sc.close();
//        } catch (IOException e){
//
//        }



//        ArrayList<Member> members = new ArrayList<>();
//
//        System.out.println("Enter the keyword in member list you want to search: ");
//        String input = scanner.nextLine(); // Enter the keyword want to search
//        String pattern = ".*"+input+".*"; // Making the pattern for searching
//
//        boolean checkKeyWordExists = false;
//        for (int i = 0 ; i < memberList.size(); i ++){
//            if (memberList.get(i).toString().matches(pattern)){
//                members.add(memberList.get(i));
//                System.out.println(memberList.get(i).toString());
//                checkKeyWordExists = true;
//            }
//        }
//                System.out.println(checkKeyWordExists);
//
//        int count = 0 ;
//        int size = (int) Math.ceil(memberList.size() / 10.0);
//
//        if (size > 1){
//            Member [][] arr = new Member[size][10];
//            for (int z = 0 ; z <size; z ++ ){
//                for (int y = 0 ; y < 10 ; y++){
//                    if (count >= memberList.size() ){
//                        break;
//                    } else {
//                        arr[z][y] = memberList.get(count);
//                        System.out.println(arr[z][y].toString());
//                        count++;
//                    }
//                }
//            }
//        } else {
//            for (int j = 0 ; j < memberList.size(); j++){
//                System.out.println(memberList.get(j).toString());
//            }
//        }

//        int [] [] arr = new int[3][10];
//        for (int i = 0 ; i < 3 ; i ++){
//            for (int j = 0 ; j < 10 ; j ++){
//                arr [i] [j] = 2 + i + j;
//            }
//        }

//        int tmp = 0;
//        boolean check = true;
//        while (check){
//            try {
//                for (int j = 0 ; j < 10 ; j ++){
//                    System.out.println(arr[tmp][j]);
//                }
//                System.out.println("Enter the function:");
//                System.out.println("n is the next page \np is the " +
//                        "previous page\nq for quit:");
//                String input1 = scanner.nextLine().toLowerCase();
//                switch (input1){
//                    case "n":
//                        if (tmp < 3 - 1)
//                            tmp++;
//                        break;
//                    case "p":
//                        if (tmp > 0)
//                            tmp--;
//                        break;
//                    case "q":
//                        check = false;
//                        break;
//                }
//            } catch (Exception e){
//                check = false;
//            }
//    }
//
//        String pattern1 = ".*@rmit\\.edu\\.vn";
//        String test = "s3121@rmit2edu.vn";
//        System.out.println(test.matches(pattern1));

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
                itemList.getItems().get(i);
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
}
