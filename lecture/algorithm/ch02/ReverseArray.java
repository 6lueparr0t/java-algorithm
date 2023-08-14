import java.util.Scanner;

public class ReverseArray {
  static void swap(int[] a, int idx1, int idx2) {
    System.out.printf("a[%d] <-> a[%d]\n", idx1, idx2);
    int t = a[idx1];
    a[idx1] = a[idx2];
    a[idx2] = t;
  }

  static void reverse(int[] a) {
    for (int i = 0; i < a.length / 2; i++) {
      swap(a, i, a.length - i - 1);
      for (int j = 0; j < a.length; j++) {
        System.out.print(a[j] + " ");
      }
      System.out.printf("\n\n");
    }
  }

  static int sumOf(int[] a) {
    int sum = 0;

    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }

    return sum;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("요솟수 : ");
    int num = scan.nextInt();

    int[] x = new int[num];

    for (int i = 0; i < num; i++) {
      System.out.print("x[" + i + "] : ");
      x[i] = scan.nextInt();
    }

    System.out.println();
    reverse(x);

    System.out.println("요소를 역순으로 정렬했습니다.");
    for (int i = 0; i < num; i++) {
      System.out.println("x[" + i + "] = " + x[i]);
    }

    System.out.println("모든 요소의 합계 : " + sumOf(x));

    scan.close();
  }
}
