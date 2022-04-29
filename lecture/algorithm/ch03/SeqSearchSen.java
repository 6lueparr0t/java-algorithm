import java.util.Scanner;

public class SeqSearchSen {
  static int seqSearchSen(int[] a, int n, int key) {
    System.out.print("   |");
		for (int k = 0; k < n; k++)
			System.out.printf("%4d", k);
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++)
			System.out.print("-");
		System.out.println();

    a[n] = key;

    for(int i=0; true; i++) {
      System.out.print("   |");
			System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
			System.out.printf("%3d|", i);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
      if(a[i]==key) return i==n?-1:i;
    }
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("개수? : ");
    int num = scan.nextInt();
    int[] x = new int[num+1];

    for  (int i=0; i<num; i++) {
      System.out.printf("x[%d] :", i);
      x[i] = scan.nextInt();
    }

    System.out.print("검색할 값: ");
    int key = scan.nextInt();

    int idx = seqSearchSen(x, num, key);

    if (idx == -1) {
      System.out.println("결과를 찾지 못했습니다.");
    } else {
      System.out.printf("%d ==> x[%d]:%d\n", key, idx, x[idx]);
    }

    scan.close();
  }
}
