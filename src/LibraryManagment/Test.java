package LibraryManagment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Member> memberList = new ArrayList<>();
        final File MEMBERFILE = new File("src/Member.txt");
//        System.out.println("Enter the keyword you want to search: ");
//        String input = scanner.nextLine();
//        String pattern = ".*"+input+".*";
//        String hello = "hellocac\nban";
//        System.out.println(hello.matches(pattern));

        try{
            Scanner sc = new Scanner(MEMBERFILE);
            while (sc.hasNext()) {
                String name = sc.nextLine();
                String id = sc.nextLine();
                String phone = sc.nextLine();
                String mail = sc.nextLine();
                String address = sc.nextLine();
                String date = sc.nextLine();
                String status = sc.nextLine();
                memberList.add(new Member(name, id, phone, mail, address, date, status));
            }
            sc.close();
        } catch (IOException e){

        }



//        ArrayList<Member> members = new ArrayList<>();
//
//        System.out.println("Enter the keyword in member list you want to search: ");
//        String input = scanner.nextLine(); // Enter the keyword want to search
//        String pattern = ".*"+input+".*"; // Making the pattern for searching
//
//        boolean checkKeyWordExists = false;
//        for (int i = 0 ; i < memberList.size(); i ++){
//            if (memberList.get(i).toString().matches(pattern)){
//                members.add(memberList.get(i));
//                System.out.println(memberList.get(i).toString());
//                checkKeyWordExists = true;
//            }
//        }
//                System.out.println(checkKeyWordExists);
//
//        int count = 0 ;
//        int size = (int) Math.ceil(memberList.size() / 10.0);
//
//        if (size > 1){
//            Member [][] arr = new Member[size][10];
//            for (int z = 0 ; z <size; z ++ ){
//                for (int y = 0 ; y < 10 ; y++){
//                    if (count >= memberList.size() ){
//                        break;
//                    } else {
//                        arr[z][y] = memberList.get(count);
//                        System.out.println(arr[z][y].toString());
//                        count++;
//                    }
//                }
//            }
//        } else {
//            for (int j = 0 ; j < memberList.size(); j++){
//                System.out.println(memberList.get(j).toString());
//            }
//        }

        int [] [] arr = new int[3][10];
        for (int i = 0 ; i < 3 ; i ++){
            for (int j = 0 ; j < 10 ; j ++){
                arr [i] [j] = 2 + i + j;
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
                System.out.println("n is the next page \np is the " +
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
//
//        String pattern1 = ".*@rmit\\.edu\\.vn";
//        String test = "s3121@rmit2edu.vn";
//        System.out.println(test.matches(pattern1));

}}
