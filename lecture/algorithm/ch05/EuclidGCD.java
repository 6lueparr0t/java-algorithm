import java.util.Scanner;

public class EuclidGCD {
  // 정수 x, y의 최대공약수를 구하여 반환합니다.
  static long recursiveGcd(long x, long y) {
    if (y == 0) {
      return x;
    } else {
      return recursiveGcd(y, x % y);
    }
  }

  static long whileGcd(long x, long y) {
    long tmp = 0;

    while(true) {
      if (y == 0) {
        return x;
      }

      tmp = y;
      y = x % y;
      x = tmp;
    }
  }

  static int gcdArray(int[] a) {
    int result = a[0];
    for(int i=1; i<a.length; i++) {
      result = (int)whileGcd(result, a[i]);
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("두 정수의 최대공약수를 구합니다.");

    System.out.print("정수를 입력하세요. : ");
    long x = scan.nextInt();
    System.out.print("정수를 입력하세요. : ");
    long y = scan.nextInt();

    System.out.printf("두 정수의 최대 공약수는 %d 입니다. (재귀)\n", recursiveGcd(x, y));
    System.out.printf("두 정수의 최대 공약수는 %d 입니다. (비재귀)\n", whileGcd(x, y));

    System.out.print("개수 : ");
    int count = scan.nextInt();

    int[] a = new int[count];
    
    for(int i=0; i<count; i++) {
      System.out.print("입력 : ");
      a[i] = scan.nextInt();
    }

    System.out.printf("배열의 최대 공약수는 %d 입니다.\n", gcdArray(a));

    scan.close();
  }
}
