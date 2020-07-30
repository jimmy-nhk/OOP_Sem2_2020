package LibraryManagment;

public class DVD extends Item {
    // Data fields of DVD class
    private int id ; // ID will be determined by the number of DVD created
    private String author;
    private static int numberOfDVDCreated = 0 ;

    //Constructors of DVD class
    public DVD(){}

    @Override
    public String toString() {
        return null;
    }

    public DVD(String title , String publication, String year , String language,String status,String copy, String author ) {
        super(title ,  publication,  year ,  language, status, copy);
        numberOfDVDCreated ++;
        this.id = numberOfDVDCreated;
        this.author = author;
    }


}
