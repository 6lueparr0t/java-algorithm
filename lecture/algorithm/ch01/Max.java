import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.print("a 의 값 "); int a = scan.nextInt();
        System.out.print("b 의 값 "); int b = scan.nextInt();
        System.out.print("c 의 값 "); int c = scan.nextInt();

        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        System.out.printf("최댓값은 %d 입니다.", max);
        scan.close();
    }
}
