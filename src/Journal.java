package LibraryManagment;

import java.util.Scanner;

public class Journal extends Item {
    // Data fields for the Journal class
    private String issn;
    
    //Constructors of the Journal class
    public Journal(){}
    public Journal(String title , String publication, String year , String language,boolean status,int copy, String issn ) {
        super(title ,  publication,  year ,  language, status, copy);

        do {
            if (verifyISSN(issn)){
                this.issn = issn;
                break;
            }
            System.out.println("Enter again the issn in the correct format: ");
            Scanner scanner = new Scanner(System.in);
            issn = scanner.next();
        }while (true);

    }

    static boolean verifyISSN(String issn){
        if ( verifyInt(issn) && issn.length() == 8  )
            return true;
        else
            return false;
    }
}
