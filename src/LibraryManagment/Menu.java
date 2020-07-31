package LibraryManagment;

import java.util.Scanner;

public class Menu {
    // Attributes:
    public static ItemList itemList = new ItemList();
    public static MemberList memberList = new MemberList();
    public static Scanner scanner = new Scanner(System.in);


    // Methods:

    public static void main(String[] args) {

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

                switch (input){
                    case 1:
                    case 2:
                        itemList.addNewItem();
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        quit();
                }
            } catch (Exception e)
            {
                System.out.println("The input should be the integer from 1 to 10.");
            }
        }
    }

    public static void start(){}

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

    public void saveData(){}

    public static void quit(){
        System.exit(0);
    }
}
