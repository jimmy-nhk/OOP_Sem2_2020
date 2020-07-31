package LibraryManagment;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberList {
    // Data field:
    private ArrayList<Member> memberList = new ArrayList<>();
    
    // Methods:
    public void searchMember (){
        ArrayList<Member> members = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the keyword you want to search: ");
        String input = scanner.nextLine(); // Enter the keyword want to search
        String pattern = ".*"+input+".*"; // Making the pattern for searching

        boolean checkKeyWordExists = false;
        for (int i = 0 ; i < memberList.size(); i ++){
            if (memberList.get(i).toString().matches(pattern)){
                members.add(memberList.get(i));
                checkKeyWordExists = true;
            }
        }
        // Call a method helping us display a list of member in the library
        if (checkKeyWordExists){
            displayMember(members);
        } else
            displayMember(memberList);

        scanner.nextLine(); // Helps stop a program a little bit for user to see
    }

    // Display member
    public void displayMember( ArrayList<Member> members){
        Scanner scanner = new Scanner(System.in);
        int size = (int) Math.ceil(members.size() / 10.0);
        Member [][] arr = new Member[size][10];
        int tmp = 0;
        boolean check = true;
        while (check){
            try {
                for (int j = 0 ; j < 10 ; j ++){
                    System.out.println(arr[tmp][j].getString());
                }
                System.out.println("Enter the function:");
                System.out.println(" n is the next page \np is the " +
                        "previous page\nq for quit:");
                String input = scanner.nextLine().toLowerCase();
                switch (input){
                    case "n":
                        if (tmp < size - 1)
                            tmp++;
                        break;
                    case "p":
                        if (tmp > 0)
                            tmp--;
                        break;
                    case "q":
                        check = false;
                        break;
                }
            } catch (Exception e){
                check = false;
            }
        }
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
        System.out.println("Enter the expired date in integer format: \neg: 05-11-2020");
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
                            System.out.println("What is the new expired date?\neg: 05-11-2020");
                            memberList.get(i).setExpiredDate(scanner.nextLine());
                            break;
                        case "LATEFEE":
                            System.out.println("Enter the late fee: ");
                            memberList.get(i).setLateFee(scanner.nextDouble());
                            scanner.nextLine();
                            break;
                        case "0":
                            check = false;
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


    public void borrowItems (){}

    public void returnItems (){}

    public void displayBorrowedItem (){}
    
}
