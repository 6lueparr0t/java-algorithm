import java.util.Scanner;

public class SumForPos {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    long n;

    System.out.println("1부터 n까지의 합을 구합니다.");

    do {
      System.out.print("n의 값 : ");
      n = scan.nextLong();
    } while (n <= 0);

    long sum = 0;

    for (int i = 1; i <= n; i++)
      sum += i;

    System.out.printf("1 부터 %d 까지의 합은 %d 입니다.", n, sum);
    scan.close();
  }
}
