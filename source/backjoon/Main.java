package source.backjoon;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n1 = scan.nextInt();
        int n2 = scan.nextInt();

        System.out.printf("%.9f\n", (double)n1/n2);

        scan.close();
    }
}