import java.util.Scanner;

public class LastNElements {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      final int N = 5;
      int[] a = new int[N];
      int cnt = 0;
      int retry;

      System.out.println("정수를 입력하세요");

      do {
        System.out.printf("%d 번째 정수 : ", cnt + 1);
        a[cnt++ % N] = scan.nextInt();

        System.out.print("continue ? (예.1 / 아니오.2) : ");
        retry = scan.nextInt();
      } while (retry == 1);

      int i = cnt - N;
      if (i < 0) i = 0;

      for (; i<cnt; i++) {
        System.out.printf("%2d 번째의 정수 = %d\n", i+1, a[i%N]);
      }

      scan.close();
    }
  }
}
