package LibraryManagment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Member {
    // Properties of Member class
    private String fullName;
    private String id;
    private String phone;
    private String mail;
    private String address;
    private Calendar expiredDate ;
    private boolean status; // True is still available , False is expired
    private double lateFee;
    private ArrayList<Loan> loanList;

    //Constructors of Member class
    public Member(){}
    public Member(String fullName,String id,String phone,String mail,String address,String date, boolean status){
        this.fullName = fullName;
        this.id = id;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.status = status;
        lateFee = 0 ;

        // Add the expired date
        Scanner scanner = new Scanner(date);
        expiredDate.set(Calendar.DAY_OF_MONTH,scanner.nextInt());
        expiredDate.set(Calendar.DAY_OF_MONTH,scanner.nextInt());
        expiredDate.set(Calendar.YEAR,scanner.nextInt());
    }

    // Methods:
    // Set methods (mutators):

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setExpiredDate(Calendar expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void setLateFee(double lateFee) {
        this.lateFee += lateFee;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
