package source.backjoon;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n1 = scan.nextInt();
        int n2 = scan.nextInt();

        if(n1 != n2) {
            if (n1 > n2) {
                System.out.println(">");
            } else {
                System.out.println("<");
            }
        } else {
            System.out.println("==");
        }

        scan.close();
    }
}