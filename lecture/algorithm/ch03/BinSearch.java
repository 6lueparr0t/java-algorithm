import java.util.Scanner;

public class BinSearch {
  static int binSearch(int[] a, int n, int key) {
    System.out.print("   |");
    for (int k = 0; k < n; k++)
      System.out.printf("%4d", k);
    System.out.println();

    System.out.print("---+");
    for (int k = 0; k < 4 * n + 2; k++)
      System.out.print("-");
    System.out.println();

    int pl = 0;
    int pr = n - 1;

    do {
      int pc = (pl + pr) / 2;

      System.out.print("   |");
      if (pl != pc) {
        System.out.printf(String.format("  %%%ds<-%%%ds+", (pl * 4) + 1, (pc - pl) * 4 - 2), "", "");
      } else {
        System.out.printf(String.format("  %%%ds<-%%%ds+", (pc * 3), 3), "", "");
      }

      if (pc != pr) {
        System.out.printf(String.format("%%%ds->\n", (pr - pc) * 4 - 2), "");
      } else {
        System.out.println("->");
      }

      System.out.printf("%3d|", pc);
      for (int k = 0; k < n; k++)
        System.out.printf("%4d", a[k]);
      System.out.println("\n   |");

      if (a[pc] == key) {
        for (; pc > pl; pc--) {
          if (a[pc - 1] < key)
            break;
        }
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

    for (int i = 1; i < num; i++) {
      do {
        System.out.printf("x[%d] : ", i);
        x[i] = scan.nextInt();
      } while (x[i] < x[i - 1]);
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
