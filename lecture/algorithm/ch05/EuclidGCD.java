import java.util.Scanner;

public class EuclidGCD {
  // 정수 x, y의 최대공약수를 구하여 반환합니다.
  static long gcd(long x, long y) {
    if (y == 0) {
      return x;
    } else {
      return gcd(y, x % y);
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("두 정수의 최대공약수를 구합니다.");

    System.out.print("정수를 입력하세요. : ");
    long x = scan.nextInt();
    System.out.print("정수를 입력하세요. : ");
    long y = scan.nextInt();

    System.out.printf("두 정수의 최대 공약수는 %d 입니다.\n", gcd(x, y));

    scan.close();
  }
}
