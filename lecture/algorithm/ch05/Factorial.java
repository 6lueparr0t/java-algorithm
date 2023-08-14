import java.util.Scanner;

public class Factorial {
  static long recursiveFactorial(long n) {
    if (n > 0) {
      return n * recursiveFactorial(n - 1);
    } else {
      return 1;
    }
  }

  static long whileFactorial(long n) {
    long sum = 1;
    while (true) {
      if (n == 0) {
        return sum;
      }

      sum *= n--;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("정수를 입력하세요. : ");
    long x = scan.nextInt();

    System.out.printf("%d 의 팩토리얼은 %d 입니다. (재귀)\n", x, recursiveFactorial(x));
    System.out.printf("%d 의 팩토리얼은 %d 입니다. (비재귀)\n", x, whileFactorial(x));

    scan.close();
  }
}
