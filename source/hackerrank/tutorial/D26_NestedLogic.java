package source.hackerrank.tutorial;

import java.util.Calendar;
import java.util.Scanner;

public class D26_NestedLogic {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);        
        //compare
        int actualDay = scan.nextInt();
        int actualMonth = scan.nextInt();
        int actualYear = scan.nextInt();
 
        int expectedDay = scan.nextInt();
        int expectedMonth = scan.nextInt();
        int expectedYear = scan.nextInt();
        scan.close();
 
        Calendar actualCal = Calendar.getInstance();
        Calendar expectedCal = Calendar.getInstance();
 
        actualCal.set(actualYear, actualMonth - 1, actualDay);
        expectedCal.set(expectedYear, expectedMonth - 1, expectedDay);
 
        //actualCal < expectedCal
        if (actualCal.getTimeInMillis() <= expectedCal.getTimeInMillis()) {
            System.out.println(0);
        //different year
        } else if (actualYear > expectedYear) {
                System.out.println(10000);
        //different month
        } else if (actualMonth > expectedMonth) {
            int monthDiff = actualMonth - expectedMonth;

            System.out.println(500 * monthDiff);
        } else {
            int dayDiff = actualDay - expectedDay;

            System.out.println(15 * dayDiff);
        }
    }
}
