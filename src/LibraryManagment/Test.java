package LibraryManagment;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
         Calendar issuedDate = Calendar.getInstance();
         issuedDate.setTime(new Date());
         //issuedDate.set(2020,7,29);
         Calendar returnedDate = Calendar.getInstance();
         returnedDate.set(2020,8,3);
        System.out.println(issuedDate.toString());
        System.out.println(returnedDate.toString());
        long daysBetween = ChronoUnit.DAYS.between(issuedDate.toInstant(), returnedDate.toInstant());
        System.out.println(daysBetween);
    }

}
