import java.util.Scanner;

public class BinSearch {
  static int binSearch(int[] a, int n, int key) {
    int pl = 0;
    int pr = n - 1;

    do {
      int pc = (pl + pr) / 2;

      if (a[pc] == key) {
        return pc;
      } else if (a[pc] < key) {
        pl = pc + 1;
      } else {
        pr = pc - 1;
      }
    } while (pl <= pr);

    return -1;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("num : ");
    int num = scan.nextInt();
    int[] x = new int[num];

    System.out.println("오름차순으로 입력하세요.");

    System.out.print("x[0] : ");
    x[0] = scan.nextInt();

    for(int i=1; i<num; i++) {
      do {
        System.out.printf("x[%d] : ", i);
        x[i] = scan.nextInt();
      } while (x[i] < x[i-1]);
    }

    System.out.print("검색할 값 : ");
    int key = scan.nextInt();

    int idx = binSearch(x, num, key);

    if (idx == -1) {
      System.out.println("결과가 없습니다.");
    } else {
      System.out.printf("%d 은(는) x[%d]에 있습니다.", key, idx);
    }

    scan.close();
  }
}
