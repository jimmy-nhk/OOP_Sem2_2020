package LibraryManagment;

import java.util.Scanner;

public class Journal extends Item {
    // Data fields for the Journal class
    private String issn;
    
    //Constructors of the Journal class
    public Journal(){}
    public Journal(String title , String publication, String year ,
                   String language,String status,String copy, String issn ) {
        super(title ,  publication,  year ,  language, status, copy);

        //Check the constraint of ISSN
//        do {
//            if (verifyISSN(issn)){
//                this.issn = issn;
//                break;
//            } else {
//                // Re-enter the issn until it is in the right format
//                System.out.println("Enter again the issn in the correct format: ");
//                Scanner scanner = new Scanner(System.in);
//                this.issn = scanner.nextLine().trim();
//                if (verifyISSN(this.issn))
//                    break;
//            }
//        } while (true);
        this.issn = issn;

    }

    @Override
    public String toString() {
        return null;
    }



    public String getIssn() {
        return issn;
    }

    public static boolean verifyISSN(String issn){
        return verifyISSN(issn) && issn.length() == 8;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }
}



