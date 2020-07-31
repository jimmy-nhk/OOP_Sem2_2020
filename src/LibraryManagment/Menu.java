package LibraryManagment;

public class Menu {
    public static void main(String[] args) {

    }

    public static void start(){}

    // Display the menu:
    public void displayMenu(){
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
