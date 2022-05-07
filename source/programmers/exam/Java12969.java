// https://programmers.co.kr/learn/courses/30/lessons/12969
// 직사각형 별 찍기

import java.util.Scanner;

public class Java12969 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        for(int i=0; i<b; i++) {
            for(int j=0; j<a; j++) {
             System.out.print("*");
            }
            System.out.println();
        }

        scan.close();
    }
}
