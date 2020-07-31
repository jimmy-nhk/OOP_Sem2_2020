package LibraryManagment;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberList {
    // Data field:
    private ArrayList<Member> memberList = new ArrayList<>();
    
    // Methods:
    public void searchMember (){
    }

    public void addNewMember(){
        Scanner scanner = new Scanner(System.in);

        // Enter the information of the member
        System.out.println("What is your name ?");
        String name = scanner.nextLine().trim();
        System.out.println("Enter the member ID: ");
        String id = scanner.nextLine().trim();

        // Check the unique of the ID
        while (true){
            if (!checkIDUnique(id)){
                System.out.println("The Id already exists. Please re-enter the ID:");
                id = scanner.nextLine().trim();
            } else
                break;
        }

        System.out.println("Enter the phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Enter the mail:");
        String mail = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the expired date in integer format: \neg: 1 5 2020 which is May 1st 2020");
        String date = scanner.nextLine();
        System.out.println("Enter the status ( active or expired): ");
        String status = scanner.nextLine();

        memberList.add(new Member(name,id,phone,mail,address,date,status));

        // Announce the statement
        System.out.println("Successfully added");
        scanner.nextLine(); // Give the user time to see user's input

    }

    public boolean checkIDUnique( String id) {
        for (int i = 0 ; i < memberList.size(); i++){
            if (id.equalsIgnoreCase(memberList.get(i).getId())){
                return false;
            }
        }
        return true;
    }

    public void updateMemberInfo (){
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        boolean found = false;
        System.out.println("What member do you want to update.\nEnter the member ID please:");
        String id = scanner.nextLine();
        for (int i = 0 ; i < memberList.size(); i ++){
            if (id.equalsIgnoreCase(memberList.get(i).getId())){
                found = true;
                // Ask the user what information to be updated
                while (check){
                    System.out.println("What information do you want to update ?\n(Name , phone , address , ... etc)");
                    String information = scanner.nextLine().toUpperCase();
                    switch (information){
                        case "NAME":
                            System.out.println("What is the new name?");
                            memberList.get(i).setFullName(scanner.nextLine());
                            break;
                        case "PHONE":
                            System.out.println("What is the new phone?");
                            memberList.get(i).setPhone(scanner.nextLine());
                            break;
                        case "ADDRESS":
                            System.out.println("What is the new address?");
                            memberList.get(i).setAddress(scanner.nextLine());
                            break;
                        case "MAIL":
                            System.out.println("What is the new mail?");
                            memberList.get(i).setMail(scanner.nextLine());
                            break;
                        case "STATUS":
                            System.out.println("What is the new status?");
                            memberList.get(i).setStatus(scanner.nextLine());
                            break;
                        case "DATE":
                            System.out.println("What is the new expired date?\neg: 1 5 2020 which is May 1st 2020");
                            memberList.get(i).setExpiredDate(scanner.nextLine());
                            break;
                        case "LATEFEE":
                            System.out.println("Enter the late fee: ");
                            memberList.get(i).setLateFee(scanner.nextDouble());
                            scanner.nextLine();
                            break;
                        case "0":
                            check = false;
                            scanner.nextLine();
                            break;
                        default:
                            System.out.println("Cannot find the matched data field");
                    }
                }
            }
        }
        if (!found){
            System.out.println("Cannot find this member");
        }
    }

    public void displayMember(){}

    public void borrowItems (){}

    public void returnItems (){}

    public void displayBorrowedItem (){}
    
}
