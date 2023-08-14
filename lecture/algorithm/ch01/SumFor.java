import java.util.Scanner;

public class SumFor {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("n :  ");
    int n = scan.nextInt();

    System.out.printf("sum : %d\n", (1 + n) * n / 2);

    System.out.print("a :  ");
    int a = scan.nextInt();
    System.out.print("b :  ");
    int b = scan.nextInt();
    System.out.printf("sum : %d\n",
        (a < b) ? ((1 + b) * b / 2) - ((a) * (a - 1) / 2) : ((1 + a) * a / 2) - ((b) * (b - 1) / 2));
    scan.close();
  }
}
