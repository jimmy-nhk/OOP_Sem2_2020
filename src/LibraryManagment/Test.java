package LibraryManagment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
//         LocalDate issuedDate = LocalDate.now();
//        System.out.println(issuedDate);
//        String s2 = issuedDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        LocalDate c2 = LocalDate.parse("29-07-2020",DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        System.out.println(ChronoUnit.DAYS.between(issuedDate,c2));

        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter the keyword you want to search: ");
//        String input = scanner.nextLine();
//        String pattern = ".*"+input+".*";
//        String hello = "hellocacban";
//        System.out.println(hello.matches(pattern));

        int [][] arr = new int[3][10];
        for (int i = 0 ; i < 3 ; i ++){
            for (int k = 0; k < 10 ; k ++){
                arr [i][k] = 2 + k + i;
            }
        }

        int tmp = 0;
        boolean check = true;
        while (check){
            try {
                for (int j = 0 ; j < 10 ; j ++){
                    System.out.println(arr[tmp][j]);
                }
                System.out.println("Enter the function:");
                System.out.println(" n is the next page \np is the " +
                        "previous page\nq for quit:");
                String input1 = scanner.nextLine().toLowerCase();
                switch (input1){
                    case "n":
                        if (tmp < 3 - 1)
                            tmp++;
                        break;
                    case "p":
                        if (tmp > 0)
                            tmp--;
                        break;
                    case "q":
                        check = false;
                        break;
                }
            } catch (Exception e){
                check = false;
            }

    }

}}
