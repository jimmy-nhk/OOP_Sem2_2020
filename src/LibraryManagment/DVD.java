package LibraryManagment;

public class DVD extends Item {
    // Data fields of DVD class
    private int id; // ID will be determined by the number of DVD created
    private String author;
    private static int numberOfDVDCreated = 0;

    //Constructors of DVD class
    public DVD() {
    }

    public DVD(String title, String author, String publication, String year
            , String language, String status, String copy) {
        super(title, publication, year, language, status, copy);
        numberOfDVDCreated++;
        this.id = numberOfDVDCreated;
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + author + id;
    }

    @Override
    public String getString() {
        return "DVD:\n" + super.getTitle() + "\n"
                + author + "\n" + super.getPublication() + "\n"
                + super.getYear() + "\n" + super.getLanguage() + "\n" +
                super.getStatus() + "\nNumber Of Copies: " + getNumberOfCopies() +
                "\nNumber of Copies on Loan: " + super.getNumberOfCopiesOnLoan() +"\n";
    }



    //  Methods:

    public int getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}


