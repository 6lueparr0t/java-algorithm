import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    System.out.print("num : ");
    int num = scan.nextInt();
    int[] x = new int[num];

    System.out.println("오름차순으로 입력하세요.");
    System.out.print("x[0] : ");
    x[0] = scan.nextInt();

    for (int i=1; i<num; i++) {
      do {
        System.out.print("x[" + i + "] : ");
        x[i] = scan.nextInt();
      } while ( x[i] < x[i-1]);
    }

    System.out.print("검색할 값 : ");
    int key = scan.nextInt();

    int idx = Arrays.binarySearch(x, key);

    if (idx < 0) {
      System.out.printf("해당 값이 없습니다. 삽입 포인트 : %d\n", -idx-1);
    } else {
      System.out.printf("%d 은(는) x[%d] 에 있습니다.\n", key, idx);
    }

    scan.close();
  }
}
