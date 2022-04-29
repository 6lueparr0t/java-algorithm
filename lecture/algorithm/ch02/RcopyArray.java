import java.util.Scanner;

public class RcopyArray {
  static boolean eqauls(int[] a, int[] b) {
    if (a.length != b.length) {
      return false;
    }

    for (int i=0; i<a.length; i++) {
      if (a[i] != b[i]) return false;
    }

    return true;
  }

  static void copy(int[] a, int[] b) {
    int size = (a.length>b.length)?a.length:b.length;
    for (int i=0; i<size; i++) {
      a[i] = b[i];
    }
  }

  static void rcopy(int[] a, int[] b) {
    int size = (a.length>b.length)?a.length:b.length;
    for (int i=0; i<size; i++) {
      a[i] = b[b.length-1-i];
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);  

    System.out.print("배열 a의 개수 : ");
    int na = scan.nextInt();

    int[] a = new int[na];

    for (int i=0; i< na; i++) {
      System.out.print("a[" + i + "] :");
      a[i] = scan.nextInt();
    }

    System.out.print("배열 b의 개수 : ");
    int nb = scan.nextInt();

    int[] b = new int[nb];

    for (int i=0; i< nb; i++) {
      System.out.print("b[" + i + "] :");
      b[i] = scan.nextInt();
    }

    System.out.println("배열 a와 b는 " + (eqauls(a, b)?"같습니다":"같지 않습니다."));

    // copy(a, b);

    // for (int i=0; i< na; i++) {
    //   System.out.printf("a[%d] : %d\n", i, a[i]);
    // }

    rcopy(a, b);

    for (int i=0; i< na; i++) {
      System.out.printf("a[%d] : %d\n", i, a[i]);
    }

    scan.close();
  }
}
