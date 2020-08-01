package LibraryManagment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberList {
    // Data field:
    private ArrayList<Member> memberList = new ArrayList<>();
    public static final File MEMBERFILE = new File("src/Member.txt");

    // Methods:
    // Load the data from the file
    public void start()  {
        try {
            Scanner sc = new Scanner(MEMBERFILE);
            while (sc.hasNext()) {
                String name = sc.nextLine();
                String id = sc.nextLine();
                String phone = sc.nextLine();
                String mail = sc.nextLine();
                String address = sc.nextLine();
                String date = sc.nextLine();
                String status = sc.nextLine();
                memberList.add(new Member(name,id,phone,mail,address,date,status));
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("Cannot find the file");
        }
    }

    public void searchMember (){
        ArrayList<Member> members = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the keyword in member " +
                "list you want to search: ");
        String input = scanner.nextLine(); // Enter the keyword want to search
        String pattern = ".*"+input+".*"; // Making the pattern for searching

        for (int i = 0 ; i < memberList.size(); i ++){
            if (memberList.get(i).toString().toLowerCase().matches(pattern.toLowerCase())){
                members.add(memberList.get(i));
            }
        }

        if (members.size() > 0  && members.size() <= 10){
            for (int i = 0 ; i < members.size(); i++){
                System.out.println(members.get(i).getString());
                scanner.nextLine(); // Helps stop a program a little bit for user to see
            }
        } else
            // Call a method helping us display a list of member in the library
            displayMember(memberList);
    }

    // Display member
    public void displayMember( ArrayList<Member> members){
        Scanner scanner = new Scanner(System.in);
        int size = (int) Math.ceil(members.size() / 10.0);

            Member [][] arr = new Member[size][10];

            int count = 0 ; // get the element from arrayList member

            // Insert the arraylist member to array
            for (int i = 0 ; i < size; i++){
                for (int k = 0 ; k < 10 ; k ++){
                    if (count == members.size() ){
                        break;
                    } else {
                        arr[i][k] = members.get(count);
                        count++;
                    }
                }
            }

            // Display the element
            int row = 0;
            boolean check = true;
            while (check){
                try {
                    for (int j = 0 ; j < 10 ; j ++){
                        // When it is running out of element, the program will throw an exception which prevents further error
                        try {
                            System.out.println(arr[row][j].getString());
                        } catch (Exception e){
                        }
                    }
                    System.out.println("Enter the function:");
                    System.out.println("n is the next page \np is the " +
                            "previous page\nq for quit:");
                    String input = scanner.nextLine().toLowerCase();
                    switch (input){
                        case "n":
                            if (row < size - 1 ){
                                row++;
                            }
                            break;
                        case "p":
                            if (row > 0)
                                row--;
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
        Member member = new Member();
        // Enter the information of the member
        System.out.println("What is your name ?");
        member.setFullName(scanner.nextLine().trim());
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
        member.setId(id);

        System.out.println("Enter the phone number: ");
        member.setPhone(scanner.nextLine());
        System.out.println("Enter the mail:");
        member.setMail(scanner.nextLine());
        System.out.println("Enter the address:");
        member.setAddress(scanner.nextLine());
        System.out.println("Enter the expired date in integer format: \neg: 05-11-2020");
        member.setExpiredDate(scanner.nextLine());
        System.out.println("Enter the status ( active or expired): ");
        member.setStatus(scanner.nextLine());

        memberList.add(member);
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
        System.out.println("Which member do you want to update.\nEnter the member ID please:");
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
            scanner.nextLine();
        }
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void borrowItems (){}

    public void returnItems (){}

    public void displayBorrowedItem (){}
    
}
