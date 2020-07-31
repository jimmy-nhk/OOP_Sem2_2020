package LibraryManagment;

import java.util.Scanner;

public class Journal extends Item {
    // Data fields for the Journal class
    private String issn;
    
    //Constructors of the Journal class
    public Journal(){}

    @Override
    public String toString() {
        return null;
    }

    public Journal(String title , String publication, String year ,
                   String language,String status,String copy, String issn ) {
        super(title ,  publication,  year ,  language, status, copy);
        
        //Check the constraint of ISSN
        do {
            if (verifyISSN(issn)){
                this.issn = issn;
                break;
            } else {
                // Re-enter the issn until it is in the right format
                System.out.println("Enter again the issn in the correct format: ");
                Scanner scanner = new Scanner(System.in);
                this.issn = scanner.nextLine().trim();
                if (verifyISSN(this.issn))
                    break;
            }
        } while (true);

    }

    public String getIssn() {
        return issn;
    }

    static boolean verifyISSN(String issn){
        if ( verifyInt(issn) && issn.length() == 8  )
            return true;
        else
            return false;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }
}


