import java.util.Scanner;

public class Factorial {
  static long factorial(long n) {
    if (n > 0) {
      return n * factorial(n - 1);
    } else {
      return 1;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("정수를 입력하세요. : ");
    long x = scan.nextInt();

    System.out.printf("%d 의 팩토리얼은 %d 입니다.\n", x, factorial(x));

    scan.close();
  }
}
