package lecture.algorithm.ch01;

import java.util.Scanner;

public class Triangle {
    public static void triangleLB(int n) {
        System.out.println("왼쪽 아래가 직각인 삼각형을 출력합니다.");

        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void triangleLU(int n) {
        System.out.println("왼쪽 위가 직각인 삼각형을 출력합니다.");

        for(int i=n; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void triangleRU(int n) {
        System.out.println("오른쪽 위가 직각인 삼각형을 출력합니다.");

        for(int i=n; i>=0; i--) {
            for(int j=0; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void triangleRB(int n) {
        System.out.println("오른쪽 아래가 직각인 삼각형을 출력합니다.");

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void spira(int n) {
        System.out.println("피라미드");

        for(int i=1; i<=n; i++) {
            for(int j=0; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=(i-1)*2+1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void nspira(int n) {
        System.out.println("숫자 피라미드");

        for(int i=1; i<=n; i++) {
            for(int j=0; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=(i-1)*2+1; j++) {
                System.out.print(i%10);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;

        do {
            System.out.print("몇 단의 삼각형 인가요? :");
            n = scan.nextInt();
        } while(n<=0);

        triangleLB(n);
        triangleLU(n);
        triangleRU(n);
        triangleRB(n);
        spira(n);
        nspira(n);

        scan.close();
    }
}
