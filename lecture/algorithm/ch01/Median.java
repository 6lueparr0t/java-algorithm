package lecture.algorithm.ch01;

import java.util.Scanner;

public class Median {
    public static int med3(int a, int b, int c) {
        if (a >= b) {
            if (b >= c) {
                return b;
            } else if ( a <= c) {
                return a;
            } else {
                return c;
            }
        } else if (a > c) {
            return a;
        } else if (b > c) {
            return b;
        } else {
            return b;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("a 의 입력값 : "); int a = scan.nextInt();
        System.out.print("b 의 입력값 : "); int b = scan.nextInt();
        System.out.print("c 의 입력값 : "); int c = scan.nextInt();

        System.out.printf("%d\n", med3(a,b,c));
        scan.close();
    }
}
