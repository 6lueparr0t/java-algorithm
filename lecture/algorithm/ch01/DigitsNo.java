package lecture.algorithm.ch01;

import java.util.Scanner;

public class DigitsNo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        long n;
        do {
            System.out.print("n의 값 : ");
            n = scan.nextLong();
        } while (n <= 0);

        int digit = 0;
        while(n > 0) {
            n /= 10;
            digit++;
        } 
        
        System.out.printf("그 수는 %d자리 입니다.\n", digit);

        scan.close();
    }
}
